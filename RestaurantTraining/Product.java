package RestaurantTraining;

import java.math.BigDecimal;

public class Product {
    //•	A public constructor with the following parameters: String name, BigDecimal price
    //•	name – String
    //•	price - BigDecimal
    //•	Getters for the fields
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
