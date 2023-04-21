/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package ImplementsInterface;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * interface Predicatae có một phương thức test(<T>) và trả về một boolean
 * @author nguye
 */
public class RegEx {
    //Ví dụ 1
    public enum Regex implements Predicate<String> {
        UPPER("[A-Z]+"),
        LOWER("[a-z]+"),
        NUMERIC("[+-]?[A-Za-z]+");
        
        private final Pattern pattern;
        
        Regex(String pattern){
            this.pattern = Pattern.compile(pattern);
        }
        
        @Override
        public boolean test(String input) {
            return pattern.matcher(input).matches();
        }
    }
    
    //Ví dụ 2
    enum Acceptor implements Predicate<String>{
        NULL{
            @Override
            public boolean test(String s){
                return s == null;
            }
        },
        EMPTY{
            @Override
            public boolean test(String s){
                return s.equals("");
            }
        },
        NULL_OR_EMPTY{
            @Override
            public boolean test(String s){
                return (NULL.test(s) || EMPTY.test(s));
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Regex.UPPER.test("NGUYEN")); //true
        
        //test example two
        System.out.println(Acceptor.EMPTY.test("")); //true
        System.out.println(Acceptor.EMPTY.test("TEXT")); //false
        
        System.out.println(Acceptor.NULL.test(null)); //true
        System.out.println(Acceptor.NULL.test("")); //false
        
        System.out.println(Acceptor.NULL_OR_EMPTY.test("")); //true
        System.out.println(Acceptor.NULL_OR_EMPTY.test(null)); //true
    }

}
