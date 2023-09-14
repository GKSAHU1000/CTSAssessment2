package com.assessment.view.part2;

import com.assessment.controller.ProductController;
import java.util.DoubleSummaryStatistics;

/*
2. . Product Statistics:
• Use the summarizingDouble() collector to get the count, sum, min, max, and average price of products.
*/
public class P2Q1 {

    public static void main(String[] args) {

        ProductController productController = new ProductController();

        DoubleSummaryStatistics doubleSummaryStatistics = productController.doubleSummaryStatistics();
        System.out.println("Using summarizingDouble Print The Details Of all Products :");
        System.out.println(doubleSummaryStatistics);


    }
}
