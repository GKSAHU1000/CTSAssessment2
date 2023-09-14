package com.assessment.data;

import com.assessment.models.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataClass {
    public static List<Product>  getAllCartProducts = new ArrayList<>();
    public static List<Product> getAllProducts(){
        return Arrays.asList(
                new Product(1, "Apple iPhone 13", 799.99, 4.5),
                new Product(2, "Samsung Galaxy S22", 749.99, 4.6),
                new Product(3, "Google Pixel 6", 699.99, 4.7),
                new Product(4, "Sony WH-1000XM4", 349.99, 4.8),
                new Product(5, "Apple MacBook Pro", 1299.99, 4.9),
                new Product(6, "Dell XPS 13", 1199.99, 4.4),
                new Product(7, "Amazon Echo Dot", 49.99, 4.2),
                new Product(8, "Apple Watch Series 7", 399.99, 4.6),
                new Product(9, "Bose QuietComfort 35 II", 299.99, 4.7),
                new Product(10, "GoPro HERO10 Black", 499.99, 4.5));
    }
}
