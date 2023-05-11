/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package model;

/**
 *
 * @author nguye
 */
public class NoTaxProduct extends Product{

    public NoTaxProduct(String name, double price) {
        super(name, price);
    }

    public NoTaxProduct() {
    }

    @Override
    public double getImportTax() {
        return 0;
    }
}
