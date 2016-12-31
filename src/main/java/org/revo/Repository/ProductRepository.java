package org.revo.Repository;

import org.revo.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ashraf on 31/12/16.
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
   