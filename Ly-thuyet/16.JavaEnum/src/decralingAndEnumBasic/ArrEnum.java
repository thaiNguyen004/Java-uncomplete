/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package decralingAndEnumBasic;

/**
 *
 * @author nguye
 */
public class ArrEnum {
    public enum Season{
        SPRING,
        SUMMER,
        FALL,
        WINTER
    }

    //values() giúp tạo ra mảng chứa các giá trị enum
    Season[] seasons = Season.values();
    
    public void displayByForEach(){
        for(Season s : seasons){
            System.out.print(s+" ");
        }
        System.out.println("");
    }
    
    //values() cũng có thể sử dụng duyệt enum
    public void iterate(){
        for(Season season : Season.values()){
            System.out.print(season+" ");
        }
    }
    public static void main(String[] args) {
        new ArrEnum().displayByForEach();
        new ArrEnum().iterate();
    }
    
}
