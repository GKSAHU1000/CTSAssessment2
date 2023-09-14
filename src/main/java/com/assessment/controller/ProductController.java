package com.assessment.controller;

import com.assessment.data.DataClass;
import com.assessment.models.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductController {

    //Initialise the ALl data list
    public static List<Product> geAlltProducts = DataClass.getAllProducts();

    // get all product using those added by stream.Of
    public List<Product> getProductListUsingStreamOf() {
        return Stream.of(
                new Product(1, "Apple iPhone 13", 799.99, 4.5),
                new Product(2, "Samsung Galaxy S22", 749.99, 4.6),
                new Product(3, "Google Pixel 6", 699.99, 4.7),
                new Product(4, "Sony WH-1000XM4", 349.99, 4.8),
                new Product(5, "Apple MacBook Pro", 1299.99, 4.9),
                new Product(6, "Dell XPS 13", 1199.99, 4.4),
                new Product(7, "Amazon Echo Dot", 49.99, 4.2),
                new Product(8, "Apple Watch Series 7", 399.99, 4.6),
                new Product(9, "Bose QuietComfort 35 II", 299.99, 4.7),
                new Product(10, "GoPro HERO10 Black", 499.99, 4.5)
        ).collect(Collectors.toList());
    }


    // get Products by Below given Price
    public List<Product> getProductsBelowPrice(double price) {
        return geAlltProducts.stream()
                .filter(x -> x.getPrice() > price)
                .collect(Collectors.toList());
    }

    // get Products by above given  rating
    public List<Product> getProductsAboveRating(double rating) {
        return geAlltProducts.stream()
                .filter(x -> x.getRating() > rating)
                .collect(Collectors.toList());
    }


    //get ProductSort products based on their price and then by rating.
    public List<Product> getPoductSortByPriceAndRating() {
        return geAlltProducts.stream()
                .sorted(Comparator.comparing(Product::getPrice).thenComparing(Product::getRating))
                .collect(Collectors.toList());
    }

    //get Only Product name List
    public List<String> getPoductByName() {
        return geAlltProducts.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    // get only Product price list
    public List<Double> getPoductByPrice() {
        return geAlltProducts.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());
    }


    //P2Q1  get All Products Details like count, sum, min, max, and average price
    public DoubleSummaryStatistics doubleSummaryStatistics() {
        return geAlltProducts.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));

    }

    //P2Q2  add to cart based on product id
    public boolean addToCart(int pid) {
        Optional<Product> product = geAlltProducts.stream().
                filter(p -> p.getId() == pid).findFirst();
        if (product.isPresent()) {
            DataClass.getAllCartProducts.add(product.get());
            return true;
        } else {
            return false;
        }
    }

    //Get cart all products
    public List<Product> getCartProducts() {
        return DataClass.getAllCartProducts;
    }

    // get total Price of the Products
    public double calculateTotal() {
        return DataClass.getAllCartProducts.stream().mapToDouble(Product::getPrice)
                .reduce(0.0, Double::sum);
    }


    //get Product grouping by their rating
    public Map<Double, List<Product>> getProductsGroppingByRating() {

        return geAlltProducts.stream()
                .collect(Collectors.groupingBy(Product::getRating));
    }


    //P2Q3. B. - Use the partitioningBy() collector to partition products based on a certain
    //price threshold, for instance, separating premium products from regular ones.
    public Map<Boolean, List<Product>> getProductsPartitioningByPrice(Double premiumThreshold) {
        return geAlltProducts.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice() >= premiumThreshold));
    }


    // get product  by name using sequential stream
    public List<Product> findProduceByNameSeq(String pname) {
        return geAlltProducts.stream()
                .filter(prd -> prd.getName().equals(pname))
                .collect(Collectors.toList());
    }

    // get product  by name using parallel stream
    public List<Product> findProduceByNameParallel(String pname) {
        return geAlltProducts.stream()
                .parallel()
                .filter(prd -> prd.getName().equals(pname))
                .collect(Collectors.toList());
    }


    // get total Price of the cart Products using sequential Stream
    public double checkOutSeq() {
        return DataClass.getAllCartProducts.stream()
                .mapToDouble(Product::getPrice)
                .reduce(0.0, Double::sum);
    }


    // get total Price of the cart Products using Parallel Stream
    public double checkOutParallel() {
        return DataClass.getAllCartProducts.
                parallelStream()
                .sequential()
                .mapToDouble(Product::getPrice)
                .reduce(0.0, Double::sum);
    }


}
