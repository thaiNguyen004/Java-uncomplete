/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package genericsjava;

class Animals{
    public void eat(){
        System.out.println("Động vật đang ăn");
    }
}

class Dog extends Animals{
    public void bark(){
        System.out.println("Gâu gâu");
    }
} 

class Cat extends Animals{
    public void bark(){
        System.out.println("Meo meo");
    }
}
public class exampleLower <T extends Animals> {
    T value;
    public void setValue(T value){
        value = value;
    }
    public T getValue(){
        return value;
    }
    public static void main(String[] args) {
        exampleLower<Dog> e = new exampleLower<>();
        e.setValue(new Dog());
        Dog dog = e.getValue();
        dog.bark();
    }
}
