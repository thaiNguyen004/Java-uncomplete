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
public class switchCaseEnum {

    public enum Season{
        SPRING,
        SUMMER,
        FALL,
        WINTER
    }
    
    public static void EnumSwitch(Season season){
        switch(season){
            case SPRING->{
                System.out.println("Mùa xuân");
            }
            case SUMMER->{
                System.out.println("Mùa hè");
            }
            case FALL->{
                System.out.println("Mùa thu");
            }
            case WINTER->{
                System.out.println("Mùa đông");
            }
        }
    }
    
    //Một enum có các giá trị không thể thay đổi được trong thời gian chạy 
    //tuy nhiên chúng cũng có thể có các giá trị có thể thay đổi được
    public enum example{
        A,
        B;
        private int count = 0;
        public void increment()/*tăng*/{
            count++;
        }
        public void print(){
            System.out.println("Count of "+name()+" is "+count);
        }
    }

    public static void main(String[] args) {
        //Cũng bắt buộc các giá trị phải tồn tại trong enum
        EnumSwitch(Season.SUMMER);
        
        //So sánh bằng toán tử ==
        System.out.println(Season.SPRING == Season.FALL); //false
        System.out.println(Season.SPRING == Season.SPRING); //true
        
        //So sánh bằng hàm equals
        Season.WINTER.equals(Season.FALL); //false
        Season.WINTER.equals(Season.WINTER); //true
        Season.WINTER.equals("WINTER");//false
        
        //increment
        example.A.increment();
        example.A.print();
        example.B.print();
        //A-> 1; B-> 0
    }
    
}
