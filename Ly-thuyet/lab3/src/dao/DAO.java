/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package dao;

import java.util.List;
import model.Student;

public interface DAO {
    public Student createStudent(Student o);
    public Student readStudent(String idStudent);
    public void updateStudent(Student o);
    public void deleteStudent(String idStudent);
    public List<Student> getAllStudent();
}
