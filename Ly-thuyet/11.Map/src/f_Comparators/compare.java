/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package f_Comparators;

/*
• Dưới đây là một ví dụ minh họa cho sức mạnh của một comparator tùy chỉnh. 
Nó thực hiện phương thức compare() cho chuỗi với thứ tự ngược với thứ tự thông thường. 
Do đó, nó khiến một cây TreeSet được sắp xếp theo thứ tự ngược lại.
*/

//Sử dụng một comparator tùy chỉnh (Use a custom comparator)
import java.util.*;
//Một bộ so sánh đảo ngược cho Chuỗi (A reverse comparator for strings)
class MyComp implements Comparator<String> {
    @Override
    public int compare(String aStr, String bStr) {
        //Đảo ngược so sánh (reverse the comparison)
        return bStr.compareTo(aStr);
    }
    //Không cần override equals hoặc các phương thức mặc định
    //No need to override equals or the default methods
}
public class compare {

    public static void main(String[] args) {
        //Tạo một tree set (create a tree set)
        TreeSet<String> ts = new TreeSet<String>(/*Comparator*/ new MyComp());
        //Thêm các phần tử vào tree set
        //Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        
        //Hiển thị các phần tử 
        for(String element : ts){
            System.out.print(element + " ");
        }
        /*
            F E D C B A
        • Hãy xem kỹ lớp MyComp, nơi thực hiện Comparator bằng cách triển khai compare(). 
        (Như đã giải thích trước đó, việc ghi đè equals() không cần thiết hoặc phổ biến. 
        Cũng không cần thiết phải ghi đè các phương thức mặc định.) Bên trong compare(), 
        phương thức compareTo() của String được sử dụng để so sánh hai chuỗi. 
        Tuy nhiên, bStr (chứ không phải aStr) gọi compareTo(). Điều này làm thay đổi kết quả 
        của phép so sánh theo chiều ngược lại.
        */
        
        /*
        • Mặc dù cách triển khai của comparator theo thứ tự ngược bởi chương trình trước đó 
        là hoàn toàn phù hợp. 
        • Có một cách tiếp cận khác để giải quyết vấn đề. Bây giờ, bạn có thể gọi đơn giản reversed()
        trên một comparator theo thứ tự tự nhiên. Nó sẽ trả về một comparator tương đương, chỉ khác là 
        chạy theo thứ tự ngược lại. Ví dụ, giả sử chương trình trước đó, bạn có thể viết lại MyComp 
        như một comparator theo thứ tự tự nhiên, như được hiển thị dưới đây với class MyComp2.*/
        /*
        • Tiếp theo, bạn có thể sử dụng chuỗi lệnh sau để tạo một TreeSet sắp xếp các phần tử chuỗi theo thứ tự ngược lại:
        */
        
        MyComp2 mc = new MyComp2(); //Tạo một phiên bản Comparator của MyComp2
        //Truyền một phiên bản của MyComp2 theo thứ tự ngược lại vào TreeSet.
        TreeSet<String> ts2 = new TreeSet<>(mc.reversed());
        /*
        • Nếu bạn đưa mã mới này vào chương trình trước đó, nó sẽ tạo ra kết quả giống như trước đây. 
        Trong trường hợp này, không có lợi ích khi sử dụng reversed(). Tuy nhiên, 
        trong những trường hợp bạn cần tạo cả comparator theo thứ tự tự nhiên và comparator theo thứ tự ngược lại, 
        sử dụng reversed() sẽ giúp bạn dễ dàng nhận được comparator theo thứ tự ngược lại mà không cần phải viết mã một cách rõ ràng.

        • Thực ra, không cần thiết phải tạo lớp MyComp2 trong các ví dụ trước đó vì một biểu thức lambda 
        có thể được sử dụng một cách dễ dàng thay thế. Ví dụ, bạn có thể hoàn toàn loại bỏ lớp MyComp2
        và tạo comparator cho chuỗi bằng cách sử dụng câu lệnh sau:
        // Sử dụng biểu thức lambda để triển khai Comparator<String>.
                Comparator<String> mc = (aStr, bStr) -> aStr.compareTo(bStr);

        • Một điểm khác: trong ví dụ đơn giản này, cũng có thể chỉ định một comparator theo thứ tự ngược lại 
        thông qua một biểu thức lambda trực tiếp trong cuộc gọi constructor của TreeSet(), 
        như được hiển thị dưới đây:
        */
        //Truyền một bộ so sánh đảo ngược tới TreeSet() qua lambda expressioin
        TreeSet<String> ts3 = new TreeSet<String>((aStr, bStr) -> bStr.compareTo(aStr));
        //Bằng cách thực hiện những thay đổi này, chương trình được rút ngắn đáng kể
        
        //reverseOrder
        TreeMap<String, Double> tm = new TreeMap<>(Comparator.reverseOrder());
        //put elements to the tree map
        tm.put("John Doe", 3242.14);
        tm.put("Tom Smith", 123.22);
        tm.put("Jane Baker", 1387.00);
        tm.put("Tod Hall", 99.22);
        tm.put("Ralph Smith",-19.08);
        for (Map.Entry<String, Double> entry : tm.entrySet()) {
            System.out.println(entry.getKey());
        }
        /*
        • Lợi ích chính của việc sử dụng reversed() là bạn có thể áp dụng nó lên bất kỳ Comparator nào, 
        bất kể cách bạn đã tạo nó. Điều này cho phép bạn linh hoạt chỉ định thứ tự đảo ngược trong các 
        tình huống khác nhau mà không cần tạo ra một Comparator hoàn toàn mới.

        • Trong khi đó, phương thức reverseOrder() chỉ trả về một Comparator mặc định dựa trên thứ tự tự nhiên 
        của các đối tượng và thực hiện sắp xếp ngược lại. Nó không cho phép bạn tuỳ chỉnh thứ tự sắp xếp theo
        các tiêu chí khác.
        
        • Nếu bạn cần sắp xếp theo một tiêu chí tùy chỉnh và sau đó muốn đảo ngược thứ tự, 
        tôi khuyên bạn nên sử dụng phương thức reversed() trên Comparator đã tạo thay vì reverseOrder(). 
        Điều này cho phép bạn duy trì tính linh hoạt và tùy chỉnh trong quá trình sắp xếp.
        */
        
    }
}
class MyComp2 implements Comparator<String> {
    @Override
    public int compare(String aStr, String bStr) {
        return aStr.compareTo(bStr);
    }
    
}