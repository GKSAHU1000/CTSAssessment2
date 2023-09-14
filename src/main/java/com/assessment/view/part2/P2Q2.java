package com.assessment.view.part2;

import com.assessment.Util;
import com.assessment.controller.ProductController;

/*
Cart Operations:
• Implement an addToCart method, where products can be added to a user's cart using their IDs.
• Implement a calculateTotal method which uses the reduce() method to compute the total price of products in the cart.
*/


public class P2Q2 {
    public static void main(String[] args) {
        ProductController productController = new ProductController();

        // Implement an addToCart method, where products can be added to a user's cart using their IDs
        int priodctId = 1;

        //Add to cart
        Util.AddToCart(productController,1);

        Util.AddToCart(productController,2);

        Util. AddToCart(productController,3);

        Util.AddToCart(productController,4);

        Util.AddToCart(productController,5);

         //print the cart item
        productController.getCartProducts().forEach(System.out::println);


        //Implement a calculateTotal method which uses the reduce() method to compute the total price of products in the cart.
        System.out.print("Total product price in cart: ");
        double calculateTotalPrice = productController.calculateTotal();
        System.out.println(calculateTotalPrice);

    }


}
