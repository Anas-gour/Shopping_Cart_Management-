package comparator;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args){
        Scanner sc = productService.sc;
        System.out.println("============== Welcome Shopping Cart ==============");
        while (true){
            System.out.println("Add product press --> 1 ");
            System.out.println("Remove product press --> 2 ");
            System.out.println("Update Product press --> 3 ");
            System.out.println("Calculate Total Bill press --> 4 ");
            System.out.println("Display all Products press --> 5 ");
            System.out.println("============ EXIT PRESS --> 0 ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.removeProduct();
                    break;
                case 3:
                    productService.updateProduct();
                    break;
                case 4:
                    productService.TotalBill();
                    break;
                case 5:
                    productService.displayAllProduct();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            
        }
        
    }
}
