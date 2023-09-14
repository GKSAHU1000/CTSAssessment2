package com.assessment.view.part2;

import com.assessment.controller.ProductController;

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
        productController.getProductsGroppingByRating().forEach((k,v)->
                System.out.println(k +" Ratting all products is : "+ v));


        //Use the partitioningBy() collector to partition products based on a certain price threshold,
        // for instance, separating premium products from regular o



    }
}
