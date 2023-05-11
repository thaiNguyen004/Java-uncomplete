/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package dao;

import java.util.List;

public interface DAO <T> {
    public void insert(T o);
    public void update();
    public void delete();
    public List<T> select();
}
