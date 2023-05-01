/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package g_Wildcard;

class Stats <T extends Number> {
    T[] ob;
    
    Stats (T[] o){
        ob = o;
    }
    
    double average () {
        double sum = 0;
        for (int i = 0; i < ob.length; i++){
            sum += ob[i].doubleValue();
        }
        return sum / ob.length;
    }
    
//    boolean sameAvg (Stats<T> ob) {
//        if(average() == ob.average())
//            return true;
//        return false;
//    } 
//      lỗi! yêu cầu tham số trong hàm phải cùng kiểu tức là nếu T của đối tượng gọi phương thức  
//      là Integer thì tham số được truyền vào trong phương thức được gọi bởi đối tượng gọi phương thức
//      cũng phải cùng kiểu của đối tượng đó
    
    boolean sameAvg (Stats<?> ob){
        if(average() == ob.average()){
            return true;
        }
        return false;
    }
    /*khi sử dụng wildcard Stats<?>, bạn có thể truyền vào bất kỳ đối tượng Stats nào, 
    miễn là đối tượng đó thuộc kiểu Number hoặc lớp con của Number, bởi vì trong khai báo lớp 
    Stats có ràng buộc <T extends Number> giới hạn kiểu T phải là một kiểu con của lớp Number.*/
}
public class example {

    public static void main(String[] args) {
        Short[] inums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Double[] dnums = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0};
        
        Stats<Short> iob = new Stats<Short>(inums);
        Stats<Double> dob = new Stats<Double>(dnums);
        
        if(iob.sameAvg(dob)){
            System.out.println("Đúng");
        }else{
            System.out.println("Sai");
        }
    }
    
}
