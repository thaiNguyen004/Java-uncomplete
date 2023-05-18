package TryCatchWithMultipleCatches;

class example {

    public void method() {
        //Ví dụ về sử dụng multiple catches block

        try {
            //some code that may throw exception
        } catch (NullPointerException e) {
            //handle NullPointerException
        } catch (RuntimeException e) {
            //handle RuntimeException
        } catch (Exception e) {
            //handle otherException
        } finally {
            //alway excute after handle exception
        }

        //Ví dụ về chiến lược top-down có thể gây hậu quả
        try {
            throw new RuntimeException("Run");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//catch (RuntimeException e){
        //dòng thứ 36 sẽ báo lỗi
        //lý do là đang cố gắng bắt một ngoại lệ đã được bắt trước đó
        System.out.println("RuntimeException");
        //}

        /*
         * Đoạn mã này sẽ xuất ra 'exception' thay vì 'RuntimeException' Vì
         * RuntimeException là một kiểu con của Exception, nên lần bắt đầu tiên
         * (tổng quát hơn) sẽ được khớp, Lần bắt thứ hai (cụ thể hơn) sẽ không
         * bao giờ được thực hiện. Bài học rút ra từ điều này là các khối bắt cụ
         * thể nhất sẽ xuất hiện đầu tiên và các khối chung nhất sẽ xuất hiện
         * sau cùng. (Một số trình biên dịch Java sẽ cảnh báo bạn nếu lệnh bắt
         * không bao giờ được thực thi, nhưng đây không phải là lỗi biên dịch.)
         */
 /*
         * Bắt đầu với Java SE 7, một khối catch duy nhất có thể xử lý danh sách
         * các ngoại lệ không liên quan. Loại ngoại lệ được liệt kê, được phân
         * tách bằng ký hiệu thanh dọc (|). Ví dụ:
         */
        try {
            // code có thể gây ra ngoại lệ NullPointerException hoặc ArrayIndexOutOfBoundsException
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Caught generic Exception");
        }

        /*
        * Các quy tắc bắt ngoại lệ :
            ▪ Các khối catch nên được sắp xếp từ loại ngoại lệ cụ thể đến chung nhất
            ▪ Khối catch cuối cùng nên bắt ngoại lệ chung nhất như là Exception hoặc Throwable
            ▪ Không nên bắt ngoại lệ không cần thiết, nếu ngoại không được xử lý nó sẽ lan truyền
              đến khối catch tiếp theo, nếu không có khối catch nào thì như đã nói chương trình sẽ bị dừng
            ▪ Các loại ngoại lệ trong khối catch phải là disjoint (không chồng chéo). Điều này có nghĩa là 
              một loại ngoại lệ chỉ nên được liệt kê trong một khối catch duy nhất. Nếu một 
              ngoại lệ được liệt kê trong nhiều khối catch thì chương trình sẽ không biết phải xử lý
              trong khối nào
         */
    }

}

public class Example {

    public static void main(String[] args) {
        /**
         * . Trong một số trường hợp, có thể xảy ra nhiều hơn một exception
         * trong một đoạn mã. Để xử lý loại tình huống này, bạn có thể chỉ định
         * hai hoặc nhiều lệnh catch, mỗi lệnh catch bắt một loại exception khác
         * nhau. Khi một exception được ném, mỗi lệnh catch được kiểm tra theo
         * thứ tự và lệnh đầu tiên mà kiểu của nó phù hợp với kiểu của exception
         * sẽ được thực thi. Sau khi một lệnh catch thực thi, các lệnh khác sẽ
         * được bỏ qua và thực thi tiếp tục sau khối try/catch. Ví dụ sau đây
         * bắt hai loại exception khác nhau:
         */
        try {
            int a = args.length;
            //int a = 1;
            System.out.println("a = "+ a);
            int b = 42 / a;
            int c[] = {1};
            c[42] = 99;
        } catch (ArithmeticException e) {
            System.out.println("Chia cho số 0: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Vị trí mảng không đúng: " + e);
        }
        System.out.println("After try/catch blocks");
    }

}
