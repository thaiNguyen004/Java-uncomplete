
/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */

//Tọa độ 2 chiều (Two-dimesional coordinates)
class TwoD {
    int x, y;
    TwoD (int a, int b){
        x = a;
        y = b;
    }
}
//Tọa độ 3 chiều (Three-dimesional coordinates)
class ThreeD extends TwoD{
    int z;
    ThreeD(int a, int b, int c) {
        super(a, b);
        z = c;
    }
}
class FourD extends ThreeD {
    int t;
    FourD(int a, int b, int c, int d){
        super(a, b, c);
        t = d;
    }
}

class Coords <T extends TwoD> {
    T[] coords;
    Coords(T[] ob) {
        coords = ob;
    }
}
/*Chú ý rằng lớp Coords chỉ định một tham số kiểu được giới hạn bởi TwoD. Điều này có nghĩa là 
bất kỳ mảng được lưu trữ trong một đối tượng Coords sẽ chứa các đối tượng kiểu TwoD hoặc 
một trong các lớp con của nó.

Giả sử bạn muốn viết một phương thức hiển thị tọa độ X và Y cho mỗi phần tử trong mảng coords 
của một đối tượng Coords. Vì tất cả các loại đối tượng Coords đều có ít nhất hai tọa độ (X và Y), 
điều này rất dễ dàng để làm bằng cách sử dụng wildcard, như được thể hiện ở đây:
*/
public class example {
    static void showXY (Coords <?> c){
        System.out.println("X Y Coordinates: ");
        for (int i = 0 ; i < c.coords.length; i++)
            System.out.println("X: "+c.coords[i].x +"\n"
                    + "Y: "+c.coords[i].y);
    }
/*Bây giờ, giả sử bạn muốn viết một phương thức hiển thị tọa độ X và Y cho mỗi phần tử trong mảng coords 
của một đối tượng Coords. Vì tất cả các loại đối tượng Coords đều có ít nhất hai tọa độ (X và Y), điều này 
rất dễ thực hiện bằng cách sử dụng wildcard như sau: phương thức showXY() example.java

Bởi vì Coords là một kiểu generic được giới hạn và chỉ định TwoD là giới hạn trên, tất cả các đối tượng 
có thể được sử dụng để tạo một đối tượng Coords sẽ là các mảng kiểu TwoD hoặc của các lớp được thừa kế từ TwoD. 
Do đó, showXY() có thể hiển thị nội dung của bất kỳ đối tượng Coords nào.

Tuy nhiên, nếu bạn muốn tạo một phương thức hiển thị các tọa độ X, Y và Z của một đối tượng ThreeD 
hoặc FourD, thì sao? Vấn đề là không phải tất cả các đối tượng Coords đều có ba tọa độ, vì một đối tượng Coords<TwoD> 
sẽ chỉ có X và Y. Vì vậy, làm thế nào để bạn viết một phương thức hiển thị các tọa độ X, Y và Z cho các đối tượng 
Coords<ThreeD> và Coords<FourD>, trong khi ngăn phương thức đó được sử dụng với các đối tượng Coords<TwoD>? 
Câu trả lời là sử dụng wildcard có giới hạn.*/

/*Một bounded wildcard chỉ định một giới hạn trên hoặc dưới cho đối số kiểu. Điều này cho phép bạn hạn chế các loại 
đối tượng mà một phương thức sẽ hoạt động trên. Bounded wildcard phổ biến nhất là `upper bound`, được tạo bằng cách 
sử dụng mệnh đề extends giống như cách sử dụng mệnh đề để tạo một bounded type.
Sử dụng bounded wildcard, dễ dàng tạo ra một phương thức hiển thị các tọa độ X, Y và Z của một đối tượng Coords, 
nếu đối tượng đó thực sự có ba tọa độ đó. Ví dụ, phương thức showXYZ () sau đây hiển thị các tọa độ X, Y và Z 
của các phần tử được lưu trữ trong một đối tượng Coords, nếu những phần tử đó thực sự là kiểu ThreeD
(hoặc là kiểu được kế thừa từ ThreeD):*/
    
    static void showXYZ (Coords <? extends ThreeD> c){
        System.out.println("X Y Z coordinates: ");
        for (int i = 0; i < c.coords.length; i++){
            System.out.println("X: "+c.coords[i].x +"\n"
                    + "Y: "+c.coords[i].y+"\n"
                            + "Z: "+c.coords[i].z);
        }
    }
    public static void main(String[] args) {
        TwoD td[] = {
            new TwoD(1, 4),
            new TwoD(-1, 6),
            new TwoD(4, 7)
        };
        Coords<TwoD> ctwo = new Coords<TwoD>(td);
        ThreeD thd[] = {
            new ThreeD(1, 2, 3),
            new ThreeD(3, 12, 9),
            new ThreeD(5, 1, 1)
        };
        Coords<ThreeD> cthree = new Coords<ThreeD>(thd);
        
        showXY(ctwo);
        showXY(cthree);
        
        showXYZ(cthree);
//      showXYZ(ctwo); lỗi
        
        
    }
    
}
