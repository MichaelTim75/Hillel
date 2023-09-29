package edu.hillel.lesson15;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    final private String type;
    final private BigDecimal price;
    final private Boolean enableDiscount;

    final private LocalDate addDate;

    public Product(String type, BigDecimal price) {
        this.type = type;
        this.price = price;
        this.enableDiscount=false;
        this.addDate =LocalDate.now();
    }

    public Product(String type, BigDecimal price, Boolean enableDiscount) {
        this.type = type;
        this.price = price;
        this.enableDiscount = enableDiscount;
        this.addDate =LocalDate.now();
    }

    public Product(String type, BigDecimal price, Boolean enableDiscount, LocalDate addDate) {
        this.type = type;
        this.price = price;
        this.enableDiscount = enableDiscount;
        this.addDate = addDate;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getEnableDiscount() {
        return enableDiscount;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
