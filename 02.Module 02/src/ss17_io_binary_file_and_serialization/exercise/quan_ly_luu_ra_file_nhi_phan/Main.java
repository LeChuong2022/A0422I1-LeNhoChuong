package ss17_io_binary_file_and_serialization.exercise.quan_ly_luu_ra_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ProductList> productLists = new ArrayList<>();
//        productLists.add(new ProductList(1, "Sony Xperia", "Sony", 800));
        String pathProductList = "ProductList.csv";
        productLists = readFromData(pathProductList);
        int choice;
        do {
            displayList();
            System.out.print("Enter your option: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProductList(productLists, pathProductList);
                    break;
                case 2:
                    showProductList(readFromData(pathProductList));
                    break;
                case 3:
                    findFromData(pathProductList);
                    break;
                case 4:
                    writeToFile(productLists, pathProductList);
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);

    }

    public static void displayList() {
        System.out.println("--------------OPTION--------------");
        System.out.println("1.Add product");
        System.out.println("2.Show product lists");
        System.out.println("3.Search product");
        System.out.println("4.Write to file");
        System.out.println("0.Exit");
    }

    public static void showProductList(List<ProductList> productLists) {
        System.out.println("Show product list: ");
        for (ProductList p : productLists) {
            System.out.println(p.toString());
        }
    }

    public static void addProductList(List<ProductList> productLists, String path) {
        System.out.println("Add new product");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id of product: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name of product: ");
        String name = scanner.nextLine();
        System.out.print("Enter manufacture of product: ");
        String manufacture = scanner.nextLine();
        System.out.print("Enter price of product: ");
        long price = Integer.parseInt(scanner.nextLine());
        productLists.add(new ProductList(id, name, manufacture, price));
    }

    public static List<ProductList> readFromData(String path) {
        List<ProductList> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<ProductList>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void findFromData(String path) {
        System.out.println("Find product in product of list");
        Scanner scanner = new Scanner(System.in);
        List<ProductList> readProductLists = new ArrayList<>();
        readProductLists = readFromData(path);
        System.out.print("Enter name of product, you want to find: ");
        String nameProductFind = scanner.nextLine();
        for (ProductList p : readProductLists) {
            if (nameProductFind.equals(p.getNameProduct())) {
                System.out.println(p.toString());
                return;
            }
        }
        System.out.println("No product in product list");
    }

    public static void writeToFile(List<ProductList> productLists, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(productLists);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
