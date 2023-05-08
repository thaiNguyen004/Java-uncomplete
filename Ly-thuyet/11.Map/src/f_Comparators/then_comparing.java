/*
 * Nguyễn Thái Nguyên
 * 1. static<T, U extends Comparable<U>> Comparator<T> comparing(Function<? super T, ? extends U> getKey)
 * 2. default<U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> getKey)
 * 3. comparing với các kiểu dữ liệu nguyên thủy
 * 4. thenComparing với các kiểu dữ liệu nguyên thủy
 * <Nhập mô tả tại đây>
 */
package f_Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
Đối với một ví dụ thực tế hơn sử dụng một comparator tùy chỉnh, chương trình sau đây là một 
phiên bản cập nhật của chương trình TreeMap được hiển thị trước đó để lưu trữ số dư tài khoản. 
Trong phiên bản trước, các tài khoản được sắp xếp theo tên, nhưng việc sắp xếp bắt đầu từ tên đầu tiên. 
Chương trình sau đây sắp xếp các tài khoản theo họ (last name). Để làm điều này, nó sử dụng một comparator 
so sánh họ (last name) của mỗi tài khoản. Kết quả là bản đồ được sắp xếp theo họ (last name).
*/
//So sánh toàn bộ từ cuối cùng trong 2 chuỗi
//compare last whole words in two strings
class TComp implements Comparator<String> {
    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;
        
        //Tìm chỉ số index bắt đầu của họ
        //find index of beginning of last name
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        
        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
        if(k == 0) //Họ bằng nhau, kiểm tra toàn bộ tên (last name is match, check entire name)
            return aStr.compareToIgnoreCase(bStr);
        else
            return k;
        
    }
    //Không cần override equals hoặc các phương thức mặc định
}
public class then_comparing {

    public static void main(String[] args) {
        //Sử dụng then_comparing để sắp xếp họ nếu họ bằng nhau thì so sánh toàn bộ tên (Map) (Tiêu chuẩn tên USA)
        TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());
        
        //thêm các phần tử vào map
        //put elements to the map
        tm.put("John Doe", 3242.14);
        tm.put("Tom Smith", 123.22);
        tm.put("Jane Baker", 1387.00);
        tm.put("Tod Hall", 99.22);
        tm.put("Ralph Smith",-19.08);
        
        //Lấy một set chứa các entry
        Set<Map.Entry<String, Double>> set = tm.entrySet();
        
        //Hiển thị các phần tử
        for (Map.Entry<String, Double> entry : set) {
            System.out.print(entry.getKey() +": ");
            System.out.println(entry.getValue());
        }
        System.out.println();
        
        /*
        Dưới đây là đầu ra; lưu ý rằng các tài khoản hiện được sắp xếp theo họ (last name).
            Jane Baker: 1387.0
            John Doe: 3242.14
            Tod Hall: 99.22
            Ralph Smith: -19.08
            Tom Smith: 123.22
        */
        /*
        • Lớp comparator TComp so sánh hai chuỗi chứa tên đệm và họ. Để làm điều này, 
        nó so sánh trước các họ. Để làm điều này, nó tìm vị trí của dấu cách cuối cùng trong mỗi chuỗi, 
        sau đó so sánh các phần con chuỗi bắt đầu từ điểm đó. 
        Trong trường hợp các họ tương đương nhau, các tên đệm sẽ được so sánh. 
        Điều này tạo ra một tree map được sắp xếp theo họ, và trong cùng họ được sắp xếp theo tên đệm. 
        Bạn có thể thấy điều này vì Ralph Smith đứng trước Tom Smith trong kết quả đầu ra.
        */
        
        /*
        • Có một cách khác mà bạn có thể viết mã chương trình trước đó để map được sắp xếp theo họ
        và sau đó theo tên đệm. Phương pháp này sử dụng phương thức thenComparing(). 
        Hãy nhớ rằng thenComparing() cho phép bạn chỉ định một comparator thứ hai sẽ được sử dụng nếu 
        comparator gọi trả về giá trị bằng nhau. Phương pháp này được thực hiện bằng chương trình sau, 
        nó thay đổi ví dụ trước để sử dụng thenComparing():
        */
        
        //Sử dụng thenComparing() để tạo ra một comparator so sánh họ, 
        //Và sẽ so sánh toàn bộ tên nếu họ bằng nhau
        
        //default Comparator<T> thenComparing(Comparator<? super T> thenByComp)
        CompLastName compLN = new CompLastName();
        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenByFirstName());
        
        //Tạo ra một tree map
        TreeMap<String, Double> tm2 = new TreeMap<>(compLastThenFirst);
        tm2.put("John Doe", 3434.34);
        tm2.put("Tom Smith", 123.22);
        tm2.put("Jane Baker", 1378.00);
        tm2.put("Tod Hall", 99.22);
        tm2.put("Ralph Smith", -19.08);
        
        //Tạo một set lưu trữ toàn bộ entry
        Set<Map.Entry<String, Double>> set2 = tm2.entrySet();
        for (Map.Entry<String, Double> entry : set2) {
            System.out.print(entry.getKey()+ " ");
            System.out.println(entry.getValue());
        }
        System.out.println();
        
        /*Giải thích : 
        • Phiên bản này tạo ra cùng kết quả như trước đây. Nó chỉ khác nhau trong cách thực hiện công việc. 
        Đầu tiên, hãy để ý rằng một comparator có tên CompLastNames được tạo ra. Comparator này chỉ so sánh 
        các họ (last name). Một comparator thứ hai, có tên CompThenByFirstName, so sánh toàn bộ tên, bắt đầu 
        từ tên đệm (first name). Tiếp theo, TreeMap được tạo bằng chuỗi lệnh sau:
            CompLastName compLN = new CompLastName();
            Comparator<String> compLastThenFirst = 
                                compLN.thenComparing(new CompThenByFirstName());
        • Ở đây, comparator chính là compLN. Đây là một thể hiện của CompLastNames. Được gọi thenComparing() 
        trên đó, truyền vào một thể hiện của CompThenByFirstName. Kết quả được gán cho comparator 
        có tên compLastThenFirst. Comparator này được sử dụng để xây dựng TreeMap, như được hiển thị dưới đây:
            TreeMap<String, Double> tm2 = 
                            new TreeMap<>(compLastThenFirst);
        • Sử dụng lambda expression
        */
        
        //Tạo ra một tree map
        /*Lưu ý ở ví dụ này ta sử dụng Comparator.comparing để so sánh lastname và thenComparing sẽ so sánh tên đệm (first name)
        nếu bộ so sánh comparing trả về bằng nhau*/
        TreeMap<String, Double> tm3 = new TreeMap<>(
                Comparator.comparing((String str) -> str.substring(str.lastIndexOf(' ')))
                .thenComparing((String str) -> str)
        );
        tm3.put("John Doe", 3434.34);
        tm3.put("Tom Smith", 123.22);
        tm3.put("Jane Baker", 1378.00);
        tm3.put("Tod Hall", 99.22);
        tm3.put("Ralph Smith", -19.08);
        Set<Map.Entry<String, Double>> set3 = tm3.entrySet();
        for (Map.Entry<String, Double> entry : set3) {
            System.out.print(entry.getKey()+ " ");
            System.out.println(entry.getValue());
        }
        System.out.println();
        
        
        //Kiểu dữ liệu nguyên thủy
        
        //Giả sử ta có một class Sinh viên có thuộc tính id và name, ta muốn sắp xếp một List các Sinh viên
        //theo thứ tự tăng dần của id chẳng han: (lớp SinhVien được viết bên dưới)
        List<SinhVien> dssv = new ArrayList<>();
        dssv.add(new SinhVien(2, "John"));
        dssv.add(new SinhVien(1, "Boruto"));
        dssv.add(new SinhVien(0, "Boruto"));
        dssv.add(new SinhVien(3, "Anna"));
        
        //Sử dụng comparingInt để so sánh và sắp xếp dssv tăng dần theo id
        // `::` có tác dụng tham chiếu tới constructor hoặc là các phương thức của một đối tượng
        //trong ví dụ này `::` được sử dụng để tham chiếu tới phương thức getId của SinhVien là lấy biến id làm khóa so sánh 
        Collections.sort(dssv, Comparator.comparingInt(SinhVien::getId));
        
        //Kết quả là : 
        for (SinhVien item : dssv) {
            System.out.print(item.id +" : ");
            System.out.println(item.name);
        }
        /*
            0 : Boruto
            1 : Boruto
            2 : John
            3 : Anna
        Thứ tự của id đã được sắp xếp tăng dần
        */
        
        //Một ví dụ sử dụng thenComparingInt
        Collections.sort(dssv, Comparator.comparing(SinhVien::getName).
                thenComparingInt(SinhVien::getId));
        //Trong ví dụ trên ta sắp xếp dssv dựa trên tên, nếu tên bằng nhau thì so sánh dựa vào id
        
        //Kết quả là: 
        for (SinhVien item : dssv) {
            System.out.print(item.id +" : ");
            System.out.println(item.name);
        }
        /*
            3 : Anna
            0 : Boruto
            1 : Boruto
            2 : John
        Thứ tự của name đã được sắp xếp, hãy để ý tên `Boruto` có 2 tên trùng nhau và đã sắp xếp dựa vào id
        Sinh viên có (id 0 và name là Boruto) đứng trước (id 1 và có tên là Boruto)
        */
        
        
        //Sử dụng then_comparing để sắp xếp tên nếu tên bằng nhau thì so sánh toàn bộ tên (Collection) (Tiêu chuẩn tên VN)
        //Tuy nhiên ví dụ này thực hiện trên list
        /*Giải thích bài tập: Đầu tiên sẽ so sánh tên chính, nếu tên chính bằng nhau thì so sánh toàn bộ tên
        và cho ra một danh sách (list) sắp xếp tăng dần*/
        Comparator<SinhVien> comp = 
                Comparator.comparing((SinhVien) -> SinhVien.getName()
                        .substring(SinhVien.getName().lastIndexOf(' ')));
        
        Comparator<SinhVien> compFirstThenLast = comp.thenComparing(SinhVien::getName);
        
        List<SinhVien> studentList = new ArrayList<>();
        studentList.add(new SinhVien(1, "Thái Nguyên"));
        studentList.add(new SinhVien(2, "Hoàng Dũng"));
        studentList.add(new SinhVien(3, "Tiến Vinh"));
        studentList.add(new SinhVien(4, "Hoàng Nguyên"));
        
        Collections.sort(studentList, compFirstThenLast);
        //Xuất kết quả: 
        studentList.forEach((e) -> System.out.println(e.getId() +": "+e.getName()));
        /*  2: Hoàng Dũng
            4: Hoàng Nguyên
            1: Thái Nguyên
            3: Tiến Vinh
        */
        
        //Ta thấy rằng kết quả trả về có 2 đối tượng có firstname đều là "Nguyên"
        //Nhưng fullname Hoàng Nguyên sẽ bé hơn Thái Nguyên nên Hoàng Nguyên được hiển thị trước
    }
}
//Một comparator so sánh họ (last name)
//class này phục vụ cho ví dụ ở line : 98
class CompLastName implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        int i, j;
        //Tìm vị trí đầu tiên của tên đệm
        i = aStr.lastIndexOf(' ');
        j = bStr.lastIndexOf(' ');
        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));
    }
}
//Sắp xếp dựa trên toàn bộ tên khi mà last name là bằng nhau
class CompThenByFirstName implements Comparator<String> {
    @Override
    public int compare(String aStr, String bStr) {
        return aStr.compareToIgnoreCase(bStr);
    }
    
}
class SinhVien{ 
    int id;
    String name;
    SinhVien (int a, String b){
        id = a;
        name = b;
    }
    int getId(){
        return id;
    }
    void setId(int a){
        id = a;
    }
    String getName() {
        return name;
    }
    void setName(String a) {
        name = a;
    }
}
