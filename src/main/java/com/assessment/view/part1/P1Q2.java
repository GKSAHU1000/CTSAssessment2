package com.assessment.view.part1;


import com.assessment.controller.ProductController;

/*• Use the filter() method to list products below a certain price.
• Use the filter() method again to list products with a rating above a certain
threshold.
*/
public class P1Q2 {
    public static void main(String[] args) {

        ProductController productController = new ProductController();


        //Use the filter() method to list products below a certain price.
        double belowPrice = 700.0;
        System.out.println(belowPrice + " price below all products : ");
        productController.getProductsBelowPrice(belowPrice).forEach(System.out::println);
        System.out.println();

        // Use the filter() method again to list products with a rating above a certain threshold
        double aboveRating = 4.7;
        System.out.println(aboveRating + " Rating Above all products : ");
        productController.getProductsAboveRating(aboveRating).forEach(System.out::println);
        System.out.println();


    }
}
