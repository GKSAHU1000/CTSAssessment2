package com.assessment.view.part1;

import com.assessment.controller.ProductController;
import com.assessment.models.Product;
import java.util.List;


/*
1. Product Creation and Initialization:
  • Create a Product class with attributes like id, name, price, and rating.
  • Initialize a list of products. Use Stream.of() to add products to the list.
*/

public class P1Q1 {

    public static void main(String[] args) {

        ProductController productController = new ProductController();

        // Initialize a list of products. Use Stream.of() to add products to the list.
        List<Product> productListUsingStreamOf = productController.getProductListUsingStreamOf();
        System.out.println(productListUsingStreamOf);

    }
}
