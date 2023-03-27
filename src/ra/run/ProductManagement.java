package ra.run;

import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> listProducts = new ArrayList<>();
    public static List<Catalog> listCatalogs = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục \n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm [\n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator) \n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm \n" +
                    "5. Thoát ");
            System.out.println("Nhập vào lựa chọn của bạn");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createCatalog();
                    break;
                case 2:
                    createProducts();
                    break;
                case 3:
                    sortByPrice();
                    break;
                case 4:
                    searchByProductName();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Số bạn nhập không trùng khớp, vui lòng nhập lại");
                    choice = Integer.parseInt(scanner.nextLine());
            }
        }
    }

    public static void createCatalog() {
        System.out.println("Nhập vào thông tin danh mục");
        System.out.println("Nhập vào số danh mục muốn theem vào");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập vào thông tin danh mục thứ " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            if (listCatalogs.size() == 0) {
                newCatalog.setCatalogId(1);
            } else {
                newCatalog.setCatalogId(listCatalogs.get(listCatalogs.size() - 1).getCatalogId() + 1);
            }
            listCatalogs.add(newCatalog);
        }
        for (Catalog listCata : listCatalogs
        ) {
            listCata.displayData();
        }
    }

    public static void createProducts() {
        System.out.println("Nhập vào thông tin sản phẩm");
        System.out.println("Nhập vào số sản phẩm bạn muốn thêm");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập vào thông tin danh mục thứ " + (i + 1));
           Product newProduct = new Product();
            newProduct.inputData();
            if (listProducts.size() == 0) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(listProducts.get(listProducts.size() - 1).getProductId() + 1);
            }
            listProducts.add(newProduct);
        }
        for (Product listPro : listProducts
        ) {
            listPro.displayData();
        }
    }
    public  static void sortByPrice(){
        Collections.sort(listProducts);
        for (Product listPro : listProducts
             ) {
            listPro.displayData();
        }
    }
    public static void searchByProductName(){
        System.out.println("Nhập vào sản phẩm banj muốn tìm kiếm");
        String inputProductName=scanner.next();
       List<Product> listSearch = new ArrayList<>();
        for (Product searchPro : listProducts
             ) {
            if (searchPro.getProductName().contains(inputProductName)){
                listSearch.add(searchPro);
            }
        }
        System.out.println("Danh sách tìm kiếm : ");
        for (Product list:listSearch
             ) {
            list.displayData();
        }
    }

}
