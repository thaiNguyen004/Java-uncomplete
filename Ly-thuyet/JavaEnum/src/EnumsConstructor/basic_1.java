/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package EnumsConstructor;

/**
 *
 * @author nguye
 */
public class basic_1 {

    public enum Coin {
        PENNY(1),
        NICKEL(5),
        DIME(10),
        QUARTER(50);

//        private int value;
        private final int value;

        Coin(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Season {
        SPRING(1, true),
        SUMMER(2),
        FALL(3, false),
        WINTER(4, true);

        private final int value;
        private final boolean isbool;

        Season(int value) {
            this.value = value;
            this.isbool = false;
        }

        Season(int value, boolean bool) {
            this.value = value;
            this.isbool = bool;
        }

        public int getValue() {
            return value;
        }

        public boolean getBool() {
            return isbool;
        }
    }

    public static void main(String[] args) {
        System.out.println(Coin.PENNY.value); //1
        System.out.println(Coin.PENNY.getValue()); //1
        /*Lưu ý rằng việc truy cập trực tiếp vào biến value trong enum Coin là không được khuyến 
        khích, thay vào đó nên sử dụng phương thức getValue() để trả về giá trị của enum.*/

        System.out.println(Season.SPRING.value + " "+ Season.SPRING.isbool);
    }

}
