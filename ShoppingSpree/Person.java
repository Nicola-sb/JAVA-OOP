package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder.append(name+ " - ");
        List<String>productsString=productList.stream().map(Product::getName).collect(Collectors.toList());//==-> map.(product -> product.getName()).
        builder.append(String.join(", ",productsString));
        if(productsString.isEmpty()){
            System.out.printf("%s - Nothing bought",getName());
        }
        return builder.toString();
    }

    //-	name: String
    //-	money:  double
    //-	products:  List<Product>
    //+ 	Person (String,  double)
    //-	setName (String): void
    //-	setMoney (double): void
    //+	buyProduct (Product): void
    //+	getName(): String
    private String name;
    private double money;
    private List<Product>productList;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        productList=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if(money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    ////+	buyProduct (Product): void
    public void buyProduct(Product product){
        if(money<product.getCost()){
              throw new IllegalArgumentException(String.format("%s can't afford %s",name,product.getName()));
        }
        productList.add(product);
        money=money-product.getCost();
    }
}
