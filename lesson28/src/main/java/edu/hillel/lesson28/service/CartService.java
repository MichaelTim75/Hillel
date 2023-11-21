package edu.hillel.lesson28.service;

import edu.hillel.lesson28.dao.ProductRepository;
import edu.hillel.lesson28.model.CartProduct;
import edu.hillel.lesson28.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope("prototype")
public class CartService {
    private final Map<Integer, CartProduct> products = new HashMap<>();

    @Autowired
    ProductRepository productRepository;

    public CartService addProduct(int id, int count) {
        CartProduct cartProduct = products.get(id);
        Product product = productRepository.getProductById(id);
        if (cartProduct == null) {
            products.put(id, new CartProduct(id, product.getName(), count));
        } else {
            products.replace(id, new CartProduct(id, product.getName(), cartProduct.getCount() + count));
        }
        return this;
    }

    public CartService deleteProduct(int id, int count) {
        CartProduct cartProduct = products.get(id);
        Product product = productRepository.getProductById(id);
        if (cartProduct != null) {
            if (cartProduct.getCount() > count) {
                products.replace(id, new CartProduct(id, product.getName(), cartProduct.getCount() - count));
            } else {
                products.remove(id);
            }
        }
        return this;
    }

    public List<CartProduct> getProducts() {
        return products.values().stream().toList();
    }
}
