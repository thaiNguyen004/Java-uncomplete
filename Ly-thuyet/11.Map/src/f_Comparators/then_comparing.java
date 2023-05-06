/*
 * Nguyễn Thái Nguyên
 * 1. static<T, U extends Comparable<U>> Comparator<T> comparing(Function<? super T, ? extends U> getKey)
 * 2. default<U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T, ? extends U> getKey)
 * 3. comparing với các kiểu dữ liệu nguyên thủy
 * 4. thenComparing với các kiểu dữ liệu nguyên thủy
 * <Nhập mô tả tại đây>
 */
package f_Comparators;

import java.util.Comparator;
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
        //tạo một tree map 
        //create a tree map
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