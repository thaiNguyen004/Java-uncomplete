/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package SingletonEnum;

//Ví dụ về singleton triển khai bằng class
class SingletonExample {

    private static SingletonExample instance = null;

    private SingletonExample() {
        // private constructor to prevent instantiation from outside
    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }
}

public class Singleton {
    //Cách triển khai singleton bằng enum
    public enum Attendant{
        INSTANCE;
        private Attendant(){
            //perform some initialization routine   
            //thực hiện một số thủ tục khởi tạo
        }
        public void sayHello(){
            System.out.println("Hello world");
        }
    }
    public static void main(String[] args) {
        Attendant.INSTANCE.sayHello();
    }
}
