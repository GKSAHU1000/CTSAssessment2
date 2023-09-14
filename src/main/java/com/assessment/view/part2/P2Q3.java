package com.assessment.view.part2;

import com.assessment.controller.ProductController;
import com.assessment.models.Product;

import java.util.List;
import java.util.Map;

/*
3. Product Grouping:
• Use the groupingBy() collector to group products by their rating.
• Use the partitioningBy() collector to partition products based on a certain
price threshold, for instance, separating premium products from regular o
*/


public class P2Q3 {

    public static void main(String[] args) {

        ProductController productController = new ProductController();

        //Use the groupingBy() collector to group products by their rating.
        Map<Double, List<Product>> productsGroppingByRating = productController.getProductsGroppingByRating();
        productsGroppingByRating.forEach((k, v)->
                System.out.println(k +" Ratting all products is : "+ v));

        System.out.println();
        System.out.println();
        //Use the partitioningBy() collector to partition products based on a certain price threshold,
        // for instance, separating premium products from regular o
        Map<Boolean, List<Product>> productsGroppingByRating1 =
                productController.getProductsPartitioningByPrice(400.0);
                productsGroppingByRating1.forEach((k, v)->
                System.out.println(k +" : "+ v));


    }
}
