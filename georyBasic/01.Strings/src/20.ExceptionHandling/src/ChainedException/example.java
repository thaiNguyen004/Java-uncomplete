/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package ChainedException;

import static ChainedException.ChainExcDemo.demoproc;

/**
 * Chained Exception hiểu đơn giản là ngoại lệ chuỗi
 * Giữa Ngoại lệ cơ bản gây ra lỗi và ngoại lệ nguyên nhân gây ra ngoại lệ đó
 */

/**
 *. Cách đây một số năm, một tính năng đã được tích hợp vào hệ thống ngoại lệ: 
 * ngoại lệ xếp chồng. Tính năng này cho phép bạn liên kết một ngoại lệ khác với
 * một ngoại lệ. Ngoại lệ thứ hai này mô tả nguyên nhân của ngoại lệ đầu tiên. 
 * Ví dụ, hãy tưởng tượng một tình huống trong đó một phương thức ném ra một 
 * ArithmeticException vì một lần chia cho số không. Tuy nhiên, nguyên nhân thực sự
 * của vấn đề đó là một lỗi I/O đã xảy ra, khiến cho số chia bị đặt sai. Mặc dù 
 * phương thức chắc chắn phải ném ra một ArithmeticException, vì đó là lỗi đã xảy ra,
 * bạn cũng có thể muốn cho mã gọi biết rằng nguyên nhân chính là một lỗi I/O. 
 * Ngoại lệ xếp chồng cho phép bạn xử lý vấn đề này và bất kỳ tình huống nào khác
 * trong đó các lớp ngoại lệ tồn tại.
 * Để cho phép ngoại lệ xếp chồng, hai constructor và hai phương thức đã được 
 * thêm vào Throwable. Các constructor được hiển thị ở đây:
 * Throwable(Throwable causeExc)
 * Throwable(String msg, Throwable causeExc)
 * 
 * Trong dạng đầu tiên, causeExc là ngoại lệ gây ra ngoại lệ hiện tại. Nghĩa là causeExc
 * là nguyên nhân cơ bản của một ngoại lệ đã xảy ra. Dạng thứ hai cho phép bạn chỉ định
 * một mô tả cùng lúc với việc chỉ định một ngoại lệ gây ra. Hai constructor này cũng đã
 * được thêm vào các lớp Error, Exception và RuntimeException.
 * Các phương thức xếp chồng ngoại lệ được hỗ trợ bởi Throwable là getCause() và initCause().
 */

class ChainExcDemo {
    static void demoproc(){
        //Tạo ra một ngoại lệ
        NullPointerException e = new NullPointerException("Lớp trên cùng");
        e.initCause(new ArithmeticException("Nguyên nhân"));
        throw e;
    }
}

public class example {

    public static void main(String[] args) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            //Hiển thị exception gốc
            System.out.println("Caught: "+e);
            //Hiển thị exception nguyên nhân
            System.out.println("Display cause: "+e.getCause());
        }
        
        //Ví dụ 2 sử dụng Throwable(String msg, Throwable causeExc)
        try {
            int a = 0;
            int c = 42 / a;
        } catch(ArithmeticException e){
            throw new RuntimeException("Lỗi khi chia", e);
        }
    }
    
}
