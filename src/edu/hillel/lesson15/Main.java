package edu.hillel.lesson15;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    final static String TYPE_FOR_FILTER = "Book";
    public static void main(String[] args) {

//        1
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product("Book",new BigDecimal(12)));
        products1.add(new Product("Book",new BigDecimal(250)));
        products1.add(new Product("Book",new BigDecimal(1122)));
        products1.add(new Product("Book",new BigDecimal(2500)));
        products1.add(new Product("Something other",new BigDecimal(12)));
        products1.add(new Product("Something other",new BigDecimal(33)));

        List<Product> byTypeAndTillPrice = getByTypeAndAbovePrice(products1, new BigDecimal(250));
        System.out.println("Exercise 1");
        byTypeAndTillPrice.forEach(product -> System.out.println("Type=\""+product.getType()+"\", price="+product.getPrice()));

        //2
        List<Product> products2 = new ArrayList<>();
        products2.add(new Product("Book",new BigDecimal(12),true));
        products2.add(new Product("Book",new BigDecimal(250),false));
        products2.add(new Product("Book",new BigDecimal(1122),true));
        products2.add(new Product("Book",new BigDecimal(2500),false));
        products2.add(new Product("Something other",new BigDecimal(12),true));
        products2.add(new Product("Something other",new BigDecimal(33),false));

        List<Product> byTypeAndDiscount = getByTypeAndDiscount(products2);
        System.out.println("Exercise 2");
        byTypeAndDiscount.forEach(product -> System.out.println("Type=\""+product.getType()+"\", price="+product.getPrice()));

        //3
        System.out.println("Exercise 3");
        System.out.println(getMinByTypeAndPrice(products2));

        System.out.println("Exercise 3 with exception");
        products2.clear();
        try {
            System.out.println(getMinByTypeAndPrice(products2));
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        //4
        List<Product> products4 = new ArrayList<>();
        products4.add(new Product("Book",new BigDecimal(12),true, LocalDate.of(2023,8,25)));
        products4.add(new Product("Apple",new BigDecimal(256),true, LocalDate.of(2023,9,15)));
        products4.add(new Product("Book",new BigDecimal(34),true, LocalDate.of(2023,9,20)));
        products4.add(new Product("TV",new BigDecimal(534),true, LocalDate.of(2023,9,25)));
        products4.add(new Product("Apple",new BigDecimal(1),true, LocalDate.of(2023,9,26)));

        System.out.println("Exercise 4");
        List<Product> lastThreeProducts = getLastThreeProducts(products4);
        lastThreeProducts.forEach(product -> System.out.println("Type=\""+product.getType()+"\", price="+product.getPrice()+", add date="+product.getAddDate()));

        System.out.println("Exercise 5");
        System.out.println("total price for type \""+TYPE_FOR_FILTER+"\" is "+getTotalPriceByFilter(products4));

        System.out.println("Exercise 6");
        Map<String, List<Product>> vocabulary = getGroupingByType(products4);
        System.out.println(vocabulary);
        //more pretty print
        vocabulary.forEach((type,productList)->{
            System.out.println("Type = \""+type+"\"");
            productList.forEach(product -> System.out.println("Type=\""+product.getType()+"\", price="+product.getPrice()+", add date="+product.getAddDate()));
        });
    }

    private static List<Product> getByTypeAndAbovePrice(List<Product> products, BigDecimal abovePrice){
        return products.stream().filter(product -> (product.getType().equals(TYPE_FOR_FILTER)))
                .filter(product -> product.getPrice().compareTo(abovePrice)>0)
                .collect(Collectors.toList());
    }

    private static List<Product> getByTypeAndDiscount(List<Product> products){
        return products.stream()
                .filter(product -> product.getType().equals(TYPE_FOR_FILTER))
                .filter(Product::getEnableDiscount)
                .map(product -> new Product(product.getType(),product.getPrice().multiply(new BigDecimal("0.9")),product.getEnableDiscount()))
                .collect(Collectors.toList());
    }

    private static Product getMinByTypeAndPrice(List<Product> products){
        return products.stream()
                .filter(product -> product.getType().equals(TYPE_FOR_FILTER))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Element with type \""+TYPE_FOR_FILTER+"\" not found"));
    }

    private static List<Product> getLastThreeProducts(List<Product> products){
        return products
                .stream()
                .sorted(Comparator.comparing(Product::getAddDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    private static BigDecimal getTotalPriceByFilter(List<Product> products){
        return products.stream()
                .filter(product -> product.getType().equals(TYPE_FOR_FILTER))
                .filter(product -> product.getAddDate().getYear()==LocalDate.now().getYear())
                .map(Product::getPrice)
                .filter(price -> price.compareTo(new BigDecimal(75))<=0)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    private static Map<String,List<Product>> getGroupingByType (List<Product> products){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType,Collectors.toList()));
    }
}
