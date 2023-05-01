/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package c_WhyUseGenerics;

//NonGen is Functionally equivalent to Gen
//but does not use generics
class NonGen {
    Object ob; //bây giờ kiểu của ob là Object
    //truyền một tham chiếu có kiểu là object cho constructor
    NonGen (Object o){
        ob = o;
    }
    Object getOb(){
        return ob;
    }
    void showType(){
        System.out.println("Type: " + 
                ob.getClass().getName());
    }
}
public class example {
    //Demostrate
    public static void main(String[] args) {
        NonGen iOb;
        //Tạo một phiên bản của lớp NonGen và truyền cho biến tham chiếu iOb
        //trong khi tạo một phiên bản ta chỉ định tham số là số nguyên
        //Unboxing vẫn sảy ra
        iOb = new NonGen(20);
        
        //Show kiểu dữ liệu của iOb
        iOb.showType();
        
        //Lấy giá trị của iOb
        //Lần này cần phải ép kiểu
        int v = (Integer)iOb.getOb();
        System.out.println("Value: "+v);
        
        //Tạo một đối tượng NonGen khác sẽ thấy cái hay
        NonGen strOb = new NonGen("Hello world");
        
        //Show kiểu dữ liệu
        strOb.showType();
        
        //Lấy giá trị của strOb, một lần nữa vẫn phải ép kiểu bình thường
        String str = (String)strOb.getOb();
        System.out.println("Value: "+str);
        
        //vì cả hai đối tượng iOb và strOb đều là Object nên
        //việc viết như sau hoàn toàn biên dịch được nhưng sai về mặt khái niệm
        iOb = strOb;
        //tuy nhiên bây giờ iOb đã bị chuyển thành String
        //v = (Integer)iOb.getOb(); lỗi! vẫn chạy nhưng kết quả bị lỗi ClassCastException
        v = (Integer)iOb.getOb();
        
        /*Có một số điều thú vị trong phiên bản này. Trước tiên, hãy chú ý rằng NonGen 
        thay thế tất cả các sử dụng của T bằng Object. Điều này khiến cho NonGen có thể 
        lưu trữ bất kỳ loại đối tượng nào, giống như phiên bản dùng generic. Tuy nhiên, 
        điều này cũng ngăn chặn trình biên dịch Java có bất kỳ kiến thức thực sự nào về 
        loại dữ liệu được lưu trữ trong NonGen, điều này là xấu vì hai lý do. 
        Trước tiên, phải sử dụng các ép kiểu rõ ràng để lấy dữ liệu được lưu trữ. 
        Thứ hai, nhiều loại lỗi không phù hợp về kiểu không thể được tìm thấy 
        cho đến thời điểm chạy chương trình. Hãy xem kỹ từng vấn đề.
        Chú ý dòng này: int v = (Integer) iOb.getob();
        
        Vì kiểu trả về của hàm getob() là Object, nên việc ép kiểu sang Integer là cần thiết 
        để giá trị đó có thể được tự động unbox và lưu vào biến v. Nếu bạn loại bỏ việc ép kiểu này, 
        chương trình sẽ không biên dịch được. Trong phiên bản generic, việc ép kiểu này là ngầm định. 
        Tuy nhiên, trong phiên bản non-generic, việc ép kiểu này phải là rõ ràng. 
        Điều này không chỉ là một sự bất tiện, mà còn là một nguồn lỗi tiềm ẩn.
        Bây giờ, hãy xem xét chuỗi lệnh sau đây gần cuối chương trình:
        
        // This compiles, but is conceptually wrong!
        iOb = strOb;
        v = (Integer) iOb.getob(); // run-time error!
            
        Ở đây, strOb được gán cho iOb. Tuy nhiên, strOb tham chiếu đến một đối tượng chứa một chuỗi, 
        không phải một số nguyên. Việc gán này là hợp lệ về mặt cú pháp vì tất cả các tham chiếu NonGen 
        đều giống nhau và bất kỳ tham chiếu NonGen nào cũng có thể tham chiếu đến bất kỳ đối tượng NonGen nào khác. 
        Tuy nhiên, câu lệnh này sai về mặt ngữ nghĩa, như thể hiện ở dòng tiếp theo.Ở đây, kiểu trả về 
        của getob() được ép kiểu sang Integer, sau đó cố gắng gán giá trị này cho v. Vấn đề là iOb bây giờ 
        tham chiếu đến một đối tượng chứa một chuỗi, không phải một số nguyên. Rất tiếc, mà không có sử dụng generics, 
        trình biên dịch Java không có cách nào để biết điều này. Thay vào đó, một ngoại lệ run-time xảy ra khi ép kiểu 
        sang Integer được thực hiện. Như bạn biết, rất tệ khi có các ngoại lệ run-time xảy ra trong mã của bạn!
        
        Các chuỗi trình tự trước đó không thể xảy ra khi sử dụng generics. Nếu chuỗi trình tự này được thử trong 
        phiên bản generic của chương trình, trình biên dịch sẽ bắt được và báo lỗi, ngăn ngừa lỗi nghiêm trọng 
        dẫn đến một ngoại lệ run-time. Khả năng tạo mã an toàn kiểu trong đó các lỗi không khớp kiểu được phát hiện 
        tại thời gian biên dịch là một lợi thế chính của generics. Mặc dù việc sử dụng tham chiếu Object để tạo 
        mã "generic" luôn có thể thực hiện được, tuy nhiên mã đó không an toàn kiểu và việc sử dụng sai có thể 
        dẫn đến ngoại lệ run-time. Generics ngăn chặn điều này xảy ra. Về bản chất, thông qua generics, 
        các lỗi run-time được chuyển thành các lỗi biên dịch. Điều này là một lợi thế lớn.
        */
        
    }
    
}
