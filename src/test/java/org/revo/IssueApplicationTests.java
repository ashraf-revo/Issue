package org.revo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.revo.Domain.FollowAmount;
import org.revo.Domain.Product;
import org.revo.Domain.Size;
import org.revo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssueApplicationTests {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    MongoOperations mongoOperations;

    @Test
    public void initData() {
        productRepository.deleteAll();
        Product product1 = new Product();
        HashSet<FollowAmount.Entry<Size, Integer>> amount1 = new HashSet<>();
        amount1.add(new FollowAmount.Entry<>(Size.L, 5));
        product1.setId("1").setAmount(new FollowAmount().setAmountData(amount1));


        Product product2 = new Product();
        HashSet<FollowAmount.Entry<Size, Integer>> amount2 = new HashSet<>();
        amount2.add(new FollowAmount.Entry<>(Size.M, 10));
        product2.setId("2").setAmount(new FollowAmount().setAmountData(amount2));


        productRepository.save(product1);
        productRepository.save(product2);


    }

    @Test
    public void retrieveOrderByAmount() {
        List<Product> mappedResults = mongoOperations.aggregate(Aggregation.newAggregation(Product.class, match(where("amount._class").is(FollowAmount.class.getName())), unwind("amount.amountData"), group("id").sum("amount.amountData.value").as("sum"), sort(Sort.Direction.DESC, "sum")), Product.class).getMappedResults();
        mappedResults.forEach(product -> System.out.println(product.getId()));


    }


}
