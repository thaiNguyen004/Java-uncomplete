/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package EnumWithAbstractMethods;

/**
 *
 * @author nguye
 */
public class example {
    //Đây cũng được coi là Enum Constant Specific Body (Các hằng số enum có body rành mạch) 
    public enum Operation{
        ADD{
            public int apply(int x, int y){
                return (x + y);
            }
        },
        SUBTRACT{
            public int apply(int x, int y){
                return (x - y);
            }
        },
        MULTIPLY{
            public int apply(int x, int y){
                return (x * y);
            }
        },
        DIVIDE{
            public int apply(int x, int y){
                return (x / y);
            }
        };
        public abstract int apply(int x, int y);
    }
    
    //Ví dụ 2
    public enum City{
        HANOI("Miền Bắc"){
            public void CDFPTHN(){
                System.out.println("CD FPT HN");
            }
            @Override
            public void address(){
                System.out.println("Hà Nội, Việt Nam");
            }
        },
        HCM("Miền Nam"){
            public void CDFPTHCM(){
                System.out.println("CD FPT HCM");
            }
            @Override
            public void address(){
                System.out.println("Hồ Chí Minh, Việt Nam");
            }
        };
        final String Mien;
        City(String Mien){
            this.Mien = Mien;
        }
        public String getMien(){
            return Mien;
        }
        public abstract void address();
    }
    public static void main(String[] args) {
        City hn = City.HANOI;
        City hcm = City.HCM;
        System.out.println(hn.getMien());
        hn.address();
    }
}
