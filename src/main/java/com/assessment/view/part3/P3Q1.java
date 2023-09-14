package com.assessment.view.part3;

import com.assessment.controller.ProductController;

/*
par 3. Q1. Parallelized Product Search:
• Implement a method that searches for a product by its name using both
sequential and parallel streams. Measure the performance difference.

*/
public class P3Q1 {

    public static void main(String[] args) {

        ProductController productController = new ProductController();

        //searches for a product by its name using  sequential streams
        Long startTime1 = System.currentTimeMillis();
        productController.findProduceByNameSeq("Apple iPhone 13")
                .forEach(System.out::println);
        Long endTime1 = System.currentTimeMillis();
        System.out.println("Time Taken By sequential stream : " + (endTime1 - startTime1));

        System.out.println();

        //searches for a product by its name using  parallel streams
        Long startTime2 = System.currentTimeMillis();
        productController.findProduceByNameParallel("Apple iPhone 13")
                .forEach(System.out::println);
        Long endTime2 = System.currentTimeMillis();
        System.out.println("Time Taken By Parallel stream : " + (endTime2 - startTime2));

    }
}
