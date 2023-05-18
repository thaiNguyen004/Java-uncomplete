/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package f_Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

class Students {
    String name;
    Double gpa;
    Students(String a, Double b) {
        name = a;
        gpa = b;
    }

    public String getName() {
        return name;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    
}

public class nullsFirst_nullsLast {
    /*
        public static <T,U> Comparator<T> comparing(Function<? super T,? extends U> keyExtractor, Comparator<? super U> keyComparator)
    
    • keyExtractor là một đối tượng Function (Function<? super T, ? extends U>) được sử dụng để trích xuất
        một khóa (key) từ đối tượng đầu vào (T). Nó nhận một đối tượng kiểu T và trả về một đối tượng kiểu U (khóa). 
        Đối tượng Function này xác định cách trích xuất khóa từ đối tượng T để sử dụng trong quá trình so sánh.

    • keyComparator là một đối tượng Comparator (Comparator<? super U>) được sử dụng để so sánh các khóa (U) 
        đã trích xuất. Nó xác định cách so sánh các khóa với nhau.
        
    • Trong trường hợp không có keyComparator được chỉ định. Điều này tức là chúng ta sẽ 
        sử dụng mặc định Comparator để so sánh các khóa (U) đã trích xuất
    */
    public static void main(String[] args) {
        //nullsFirst
        
        //Sắp xếp tăng dần các phần tử trong List dựa vào gpa và chú ý rằng bên trong có giá trị null
        //Sử dụng nullsFirst => các giá trị null sẽ được coi là nhỏ hơn giá trị không null
        Comparator<Student> comp = Comparator.comparing(Student::getGpa, Comparator.nullsFirst(Double::compareTo));
        /*Để so sánh biến gpa của class Sinh Viên bạn có thể sử dụng Comparator.comparing với 
            keyExtractor là `Student::getGpa` có ý nghĩa là khóa U được trả về của đối tượng Function chính là `double gpa`
            keyComparator là `Comparator.nullsFirst(Double::comparaTo)` có ý nghĩa là nó nhận được khóa của keyExtractor và
                dùng khóa đó để so sánh đối tượng trả về là một Comparator
        */
        
        List<Student> StudentList = new ArrayList<>();
        StudentList.add(new Students("Nguyễn Thái Nguyên", null));
        StudentList.add(new Students("Vũ Tiến Vinh", 8.2));
        StudentList.add(new Students("Bùi Hoàng Dũng", null));
        StudentList.add(new Students("Nguyễn Hoàng Định", 9.8));
        
        
        
        //Vì constructor của List không có Comparator nên phải sử dụng phương thức sort của Collections
        Collections.sort(StudentList, comp);
        
        //Xuất: 
        StudentList.forEach((e) -> System.out.println(e.getName() + ": "+e.getGpa()));
        /*
            Nguyễn Thái Nguyên: null
            Bùi Hoàng Dũng: null
            Vũ Tiến Vinh: 8.2
            Nguyễn Hoàng Định: 9.8
        
        Các giá trị null đã được đưa lên đầu bằng nullsFirst
        */
        
        /**
        *Đối với nullsLast thì tương tự...
        */
        
        
        /*
            Lưu ý: , khi bạn tạo một TreeMap mà không cung cấp Comparator, TreeMap sẽ sử dụng Comparator 
        mặc định để so sánh các khóa (keys). Mặc định, TreeMap sử dụng Comparator.naturalOrder() để so sánh các khóa, 
        có nghĩa là nó sẽ sắp xếp các khóa theo thứ tự tăng dần.
        */
        
        //Sử dụng Comparator để so sánh các value của Map
        
        //Chưa hoàn thành!! Lý do : chưa biết được việc sắp xếp value ở Map có tác dụng gì
        
        Comparator<Double> comp2 = Comparator.nullsFirst(Double::compareTo);
//        TreeMap<String, Double> tm = new TreeMap<>(Comparator.comparing(Double::doubleValue, comp2)); lỗi!
//      Lỗi trên sảy ra như tôi đã nói đó là Comparator của Map mặc định sẽ lấy key để so sánh, tree map được khởi tạo
//      với key có kiểu là String trong khi Comparator lại chỉ định Double nên đã xảy ra lỗi
//      để khắc phục lỗi này phải qui định cho comparator chỉ định so sánh values của Map thay vì chỉ định key (mặc định)


        Comparator<String> comp1 = Comparator.comparing(String::toString);
        TreeMap<String, Double> tm = new TreeMap<>(comp1);
        tm.put("Nguyễn Thái Nguyên", null);
        tm.put("Vũ Tiến Vinh", 8.2);
        tm.put("Bùi Hoàng Dũng", null);
        tm.put("Nguyễn Hoàng Định", 9.8);
        
        //Xuất: 
        System.out.println();
        tm.forEach((k,v) -> System.out.println(k+": "+v));
    }
}
