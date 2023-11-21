package edu.hillel.lesson28;

import edu.hillel.lesson28.service.CartService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson28Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Lesson28Application.class, args);

        CartService cartService = applicationContext.getBean(CartService.class);

        cartService.addProduct(1, 12)
                .addProduct(3, 5)
                .addProduct(2, 4)
                .addProduct(5, 1);

        cartService.deleteProduct(2, 2);
        System.out.println(cartService.getProducts());

        CartService cartService2 = applicationContext.getBean(CartService.class);

        cartService2.addProduct(1, 1)
                .addProduct(4, 55)
                .addProduct(2, 17)
                .addProduct(5, 6);

        cartService2.deleteProduct(2, 10)
                .deleteProduct(4, 11);
        System.out.println(cartService2.getProducts());

    }

}
