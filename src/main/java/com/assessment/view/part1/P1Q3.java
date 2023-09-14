package com.assessment.view.part1;

import com.assessment.controller.ProductController;
import com.assessment.models.Product;
import java.util.List;


/*
3. Sorting and Mapping Products:
• Sort products based on their price and then by rating.
• Use the map() method to transform a list of products into a list of their names
or prices.
*/

public class P1Q3 {

    public static void main(String[] args) {

        ProductController productController = new ProductController();

        // Sort products based on their price and then by rating.
      productController.getPoductSortByPriceAndRating().forEach(System.out::println);

        System.out.println();


      //Use the map() method to transform a list of products into a list of their names
        System.out.println("transform a list of products into Based On Name : ");
        productController.getPoductByName().forEach(System.out::println);


        System.out.println();
        //Use the map() method to transform a list of products into a list of their price

        System.out.println(" transform a list of products into Map Based On Price : ");
        productController.getPoductByPrice().forEach(System.out::println);


    }
}
