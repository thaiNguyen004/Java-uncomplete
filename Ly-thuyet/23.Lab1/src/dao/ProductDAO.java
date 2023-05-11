/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author nguye
 */
public class ProductDAO  implements DAO<Product>{
    private static List<Product> listProduct = new ArrayList<>();
    
    @Override
    public void insert(Product o) {
        listProduct.add(o);
    }

    @Override
    public void update() {
        
    }

    @Override
    public void delete() {
        
    }

    @Override
    public List<Product> select() {
        return listProduct;
    }
    
}
