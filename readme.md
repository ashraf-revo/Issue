##Exception when use spring data mongodb when ``Aggregation.unwind()`` to abstract class
org.springframework.data.mapping.PropertyReferenceException: No property amountData found for type Amount! Traversed path: Product.amount.


1. i have abstract class  called Amount
2. there are two class extends Amount 
1.1. FollowAmount it have amountData variable which it is a set of values  for example [XXL:50,XL:30]
1.2. UnFollowAmount d't have any variables

when i make aggregation to ``match(where("amount._class").is(FollowAmount.class.getName()))`` then ``unwind("amount.amount")`` it say No property amount found for type Amount 
i know amount d't have amount because it is abstract class by is saved FollowAmount in the database which extends amount and have amountData 


[I'm a relative reference to a repository file](../master/src/main/java/org/revo/Domain/Size.java)