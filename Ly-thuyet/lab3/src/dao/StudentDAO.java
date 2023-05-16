/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Student;

public class StudentDAO  implements DAO{
    public List<Student> list;


    public StudentDAO() {
        list = new ArrayList<>();
        list.add(new Student("PH33935", "Nguyễn Thái Nguyên", 9.6, "Phát triển phần mềm", true));
        list.add(new Student("PH33936", "Hoàng Thùy Linh", 9, "Phát triển phần mềm", true));
        list.add(new Student("PH33937", "Bùi Thái Nguyên", 3, "Phát triển phần mềm", true));
    }
    
    @Override
    public Student createStudent(Student o) {
        boolean canAdd = list.add(o);
        if(canAdd) {
            return o;
        }else {
            return null;
        }
    }

    @Override
    public Student readStudent(String idStudent) {
        Iterator<Student> it = list.iterator();
        while(it.hasNext()) {
            Student o = it.next();
            if(o.getId().equals(idStudent)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Student o) {
        for (int i = 0; i < list.size();i++) {
            if(list.get(i).getId().equals(o.getId())) {
                list.set(i, o);
            }
        }
    }

    @Override
    public void deleteStudent(String idStudent) {
        Iterator<Student> it = list.iterator();
        while(it.hasNext()) {
            Student o = it.next();
            if(o.getId().equals(idStudent)) {
                it.remove();
            }
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return list;
    }
    
}
