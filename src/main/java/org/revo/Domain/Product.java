package org.revo.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ashraf on 26/12/16.
 */
@Document
public class Product {
    @Id
    private String id;
    private Amount amount;

    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public Amount getAmount() {
        return amount;
    }

    public Product setAmount(Amount amount) {
        this.amount = amount;
        return this;
    }
}
