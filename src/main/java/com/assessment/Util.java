package com.assessment;

import com.assessment.controller.ProductController;
import com.assessment.models.Product;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static void AddToCart(ProductController productController, int pid){
        if (productController.addToCart(pid)) {
            //Product is added in cart
            System.out.println("Product is added in your cart ");
        } else {
            //Product is not available
            System.out.println("Product is not available ");
        }
    }

}
