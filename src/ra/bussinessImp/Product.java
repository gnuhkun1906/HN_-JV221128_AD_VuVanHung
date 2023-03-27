package ra.bussinessImp;

import ra.bussiness.IShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.run.ProductManagement.listCatalogs;

public class Product implements IShop,Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm ");
        this.title = scanner.nextLine();
        System.out.println("Nhập  mô tả sản phẩm ");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhập vào gias nhập sản phẩm ");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái sản phẩm ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
        this.exportPrice = this.importPrice * RATE;
        System.out.println("Chọn danh mục sản phẩm cho sản phẩm");
        for (Catalog catalogs : listCatalogs
        ) {
            catalogs.displayData();
        }
        int catalogId = Integer.parseInt(scanner.nextLine());
        for (Catalog catalogs : listCatalogs
        ) {
            if (catalogs.getCatalogId() == catalogId) {
                this.catalog = catalogs;
                break;
            }
        }


    }

    @Override
    public void displayData() {
        System.out.println("-------------------------------------------");
        System.out.printf("Mã sản phẩm : %d\n",productId);
        System.out.printf("Tên sản phẩm : %s\n",productName);
        System.out.printf("Tên danh mục sản phẩm : %s\n",catalog.getCatalogName());
        System.out.printf("Giá bán sản phẩm : %.1f\n",exportPrice);
        System.out.printf("Trạng thái sản phẩm : %s\n",(productStatus?"còn hàng":"hết hàng"));
        System.out.println("-------------------------------------------");

    }
    @Override
    public int compareTo(Product o) {
        return (int) (this.exportPrice-o.exportPrice);
    }
}
