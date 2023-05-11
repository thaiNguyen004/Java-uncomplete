/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package control;

import dao.DAO;
import dao.ProductDAO;
import java.util.Scanner;
import model.NoTaxProduct;
import model.Product;

public class QLSP {

    Scanner sc = new Scanner(System.in);
    DAO<Product> productDAO = new ProductDAO();

    //Khai báo các biến 
    String name;
    double price;

    public void input() {
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.println("Nhập sản phẩm không thuế " + (i + 1));
                System.out.print("Nhập tên sản phẩm: ");
                name = sc.nextLine();
                System.out.print("Nhập giá: ");
                price = Double.parseDouble(sc.nextLine());
                productDAO.insert(new NoTaxProduct(name, price));
            } else {
                System.out.println("Nhập sản phẩm có thuế " + (i + 1));
                System.out.print("Nhập tên sản phẩm: ");
                name = sc.nextLine();
                System.out.print("Nhập giá: ");
                price = Double.parseDouble(sc.nextLine());
                productDAO.insert(new Product(name, price));
            }
        }
    }

    public void display() {
        for (Product ob : productDAO.select()) {
            System.out.println("name : " + ob.getName());
            System.out.println("price : " + ob.getPrice());
            System.out.println("Import tax : " + ob.getImportTax());
        }
    }
}
