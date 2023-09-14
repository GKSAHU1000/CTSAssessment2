package com.assessment.controller;

import com.assessment.data.DataClass;
import com.assessment.models.Product;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductController {

  //  public static List<Product>  DataClass.getAllCartProducts = new ArrayList<>();

    public static List<Product> geAlltProducts = DataClass.getAllProducts();

    ///•P1Q1 Initialize a list of products. Use Stream.of() to add products to the list.
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


    // P1Q2. A. Use the filter() method to list products below a certain price.
    public List<Product> getProductsBelowPrice(double price) {
        return geAlltProducts.stream()
                .filter(x -> x.getPrice() > price)
                .collect(Collectors.toList());
    }

    //P1Q2. B. Use the filter() method again to list products with a rating above a certain
    public List<Product> getProductsAboveRating(double rating) {
        return geAlltProducts.stream()
                .filter(x -> x.getRating() > rating)
                .collect(Collectors.toList());
    }


    //P1Q3. A1. Sort products based on their price and then by rating.

    public List<Product> getPoductSortByPriceAndRating() {
        return geAlltProducts.stream()
                .sorted(Comparator.comparing(Product::getPrice).thenComparing(Product::getRating))
                .collect(Collectors.toList());
    }
    //Map Product products into a list of their names
    public List<String> getPoductByName() {
        return geAlltProducts.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    ////Map Product products into a list of their Price
    public List<Double> getPoductByPrice() {
        return  geAlltProducts.stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());
    }


    //P2Q1 Use the summarizingDouble() collector to get the count, sum, min, max, and average price of products
    public DoubleSummaryStatistics doubleSummaryStatistics() {
        return geAlltProducts.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));

    }

    //P2Q2  Implement an addToCart method, where products can be added to a user's cart using their IDs
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

    //Get user cart all products
    public List<Product> getCartProducts() {
        return  DataClass.getAllCartProducts;
    }

    //Implement a calculateTotal method which uses the reduce() method to compute the total price of products in the cart.
    public double calculateTotal() {
        return  DataClass.getAllCartProducts.stream().mapToDouble(Product::getPrice)
                .reduce(0.0, Double::sum);
    }


    //P2Q3. A. - Use the groupingBy() collector to group products by their rating.
    public Map<Double, List<Product>> getProductsGroppingByRating() {

        return geAlltProducts.stream()
                .collect(Collectors.groupingBy(Product::getRating));
    }


    //P2Q3. B. - Use the partitioningBy() collector to partition products based on a certain
    //price threshold, for instance, separating premium products from regular ones.

    public Map<Boolean, List<Product>> getProductsPartitioningByPrice(Double price) {
        return geAlltProducts.stream()
                .collect(Collectors.partitioningBy(prd -> prd.getPrice() > price));
    }

    public List<Product> findProduceByNameSeq(String pname){
        return geAlltProducts.stream()
                .filter(prd->prd.getName().equals(pname))
                .collect(Collectors.toList());
    }

    public List<Product> findProduceByNameParallel(String pname){
        return geAlltProducts.stream()
                .parallel()
                .filter(prd->prd.getName().equals(pname))
                .collect(Collectors.toList());
    }


    public double checkOutSeq() {
        return  DataClass.getAllCartProducts.stream()
                .mapToDouble(Product::getPrice)
                .reduce(0.0, Double::sum);
    }
    public double checkOutParallel() {
        return  DataClass.getAllCartProducts.
                parallelStream()
                .sequential()
                .mapToDouble(Product::getPrice)
                .reduce(0.0, Double::sum);
    }



}
