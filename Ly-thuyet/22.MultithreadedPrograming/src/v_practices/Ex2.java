/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package v_practices;

import java.util.Random;

/*có 1 bài tập: 
- Cho 2 luồng, luồng 1 và luồng 2, 
- Luồng 1 thực hiện sinh số ngẫu nhiên.
- Luồng 2 sẽ bình phương số mà luồng 1 đã sinh ra. 
! Điều kiện, luồng 2 phải xử lý xong bình phương in ra màn hình thì luồng 1 mới được sinh ra tiếp.*/
class MyClass {
    int num;
    int squared;
    boolean isGenerate = false;
    boolean isSquareFirst = true;
    boolean isSquareSecond = true;
    synchronized void generateNum (String nameOfThread){
        while(isGenerate){
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        }
        try {
            System.out.print(nameOfThread+" đang tạo số: ");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        Random rand = new Random();
        num = rand.nextInt(10) + 5;
        System.out.print(num);
        System.out.println();
        
        isSquareFirst = false; 
        isGenerate = true; 
        //isSquareFirst = false; và isGenerate = true; 
        //Đảm bảo luồng nào chạy phương thức hiện tại sẽ bị wait và 
        //luồng chạy phương thức squareNumFirst sẽ thoát khỏi wait
        
        notifyAll(); //đánh thức tất cả các các luồng đang wait
    }
    
    synchronized void squareNumFirst (String nameOfThread) {
        while(isSquareFirst){
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        }
        try {
            System.out.print(nameOfThread+" đang tính toán bình phương của "+num+": ");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        squared = (int) Math.pow(num, 2);
        System.out.print(squared);
        System.out.println();
        
        isSquareFirst = true;
        isSquareSecond = false;
        //isSquareFirst = true; và isSquareSecond = false;
        //Đảm bảo luồng nào chạy phương thức hiện tại sẽ bị wait và 
        //luồng chạy phương thức isSquareSecond sẽ thoát khỏi wait
        notifyAll(); //đánh thức tất cả các các luồng đang wait
    }
    
    synchronized void squareNumSecond (String nameOfThread) {
        while(isSquareSecond){
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println("Interrupted");
            }
        }
        try {
            System.out.print(nameOfThread+" đang tính toán bình phương của "+squared+": ");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.print(Math.pow(squared, 2));
        System.out.println();
        
        isGenerate = false;
        isSquareSecond = true;
        //isGenerate = false; và isSquareSecond = true;
        //Đảm bảo luồng nào chạy phương thức hiện tại sẽ bị wait và 
        //luồng chạy phương thức generateNum sẽ thoát khỏi wait
        notifyAll(); //đánh thức tất cả các các luồng đang wait
    }
}

class class1 implements Runnable{
    Thread t;
    String name;
    MyClass o;
    class1(String str, MyClass ob) {
        name = str;
        t = new Thread(this, name);
        o = ob;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10; i++){
            o.generateNum(name);
        }
    }
}

class class2 implements Runnable{
    Thread t;
    String name;
    MyClass o;
    class2(String str, MyClass ob) {
        name = str;
        t = new Thread(this, name);
        o = ob;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10; i++){
            o.squareNumFirst(name);
        }
    }
}

class class3 implements Runnable{
    Thread t;
    String name;
    MyClass o;
    class3(String str, MyClass ob) {
        name = str;
        t = new Thread(this, name);
        o = ob;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10; i++){
            o.squareNumSecond(name);
        }
    }
}

public class Ex2 {

    public static void main(String[] args) {
        MyClass o = new MyClass();
        class1 thread1 = new class1("one", o);
        class2 thread2 = new class2("two", o);
        class3 thread3 = new class3("three", o);
        
        thread1.t.start();
        thread2.t.start();
        thread3.t.start();
    }

}
