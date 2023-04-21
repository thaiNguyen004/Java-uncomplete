/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package EnumAsTypeGenerics;

enum DayOfWeek{
    MONSDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class example <T extends Enum<T>> {
    T value;
    
    public example(T init){
        this.value = init;
    }
    public static void main(String[] args) {
        example<DayOfWeek> example = new example<>(DayOfWeek.THURSDAY); //true
        //example<String> example = new example<>(); //error
        System.out.println(example.value);
    }
}
