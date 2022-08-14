package ss12_java_collection_framework.exercise.luyen_tap_su_dung_ArrayList_LinkedList;

import java.util.Scanner;

public class MainLinkedListTest {
    public static String enterNameOfProduct() {
        String name = null;
        Scanner input = new Scanner(System.in);
        System.out.print("Name of product: ");
        name = input.nextLine();
        return name;
    }

    public static long enterPriceOfProduct(String name) {
        long price = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Price of " + name + ": ");
        price = input.nextInt();
        return price;
    }

    public static void displayOption() {
        System.out.println("Options: ");
        System.out.println("\t1.Add product");
        System.out.println("\t2.Modify product");
        System.out.println("\t3.Delete product");
        System.out.println("\t4.Display product");
        System.out.println("\t5.Search product");
        System.out.println("\t6.Sort product in increase");
        System.out.println("\t7.Sort product in decrease");
        System.out.println("\t8.Display options");
        System.out.println("\t0.Exit");
    }


    public static Product addAndModifyProduct() {
        String name = enterNameOfProduct();
        long price = enterPriceOfProduct(name);
        return new Product(name, price);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProductManagerLinkedList productList = new ProductManagerLinkedList();
        displayOption();
        productList.addProduct(new Product("Sony Xperia", 100));
        productList.addProduct(new Product("Samsung Galaxy", 120));
        productList.addProduct(new Product("Nokia 6", 50));
        int choice;
        do {
            System.out.print("Enter your option: ");
            choice = input.nextInt();
            int id;
            String nameOfProduct;
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    productList.addProduct(addAndModifyProduct());
                    break;
                case 2:
                    productList.display();
                    do {
                        System.out.print("Enter the id to modify: ");
                        id = input.nextInt();
                        if (id > productList.getSize())
                            System.out.println("Please enter id not more " + productList.getSize());
                    }
                    while (id > productList.getSize());
                    productList.modifyProduct(id, addAndModifyProduct());
                    break;
                case 3:
                    productList.display();
                    System.out.print("Enter the id to remove: ");
                    id = input.nextInt();
                    productList.removeProduct(id);
                    break;
                case 4:
                    productList.display();
                    break;
                case 5:
                    input.nextLine();//Xoa bo nho dem
                    System.out.print("Enter name of product to search: ");
                    nameOfProduct = input.nextLine();
                    int index = productList.indexOfProduct(nameOfProduct);
                    if (index == -1)
                        System.out.println("No product which you want to search.");
                    else
                        System.out.println("Id of product which you want to search: " + index);
                    break;
                case 6:
                    productList.sortIncrease();
                    productList.display();
                    break;
                case 7:
                    productList.sortDecrease();
                    productList.display();
                    break;
                case 8:
                    displayOption();
                    break;
                default:
                    System.out.println("Please enter a number between 0 and 8");
                    break;
            }
        }
        while (choice != 0);
    }

}
