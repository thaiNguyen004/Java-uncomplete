/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package equals;

import java.util.Objects;

class student {
    int field1, field2;
    String field3;

    //Đây cũng là một cách viết hashCode chuẩn
    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + field1;
        hash = 31 * hash + field2;
        hash = 31 * hash + (field3 == null ? 0 : field3.hashCode());
        return hash;
    }
    //Viết lại phương thức equals
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        student o = (student) obj;
        //Cách 1
//        return(this.field1 == o.field1 && 
//                this.field2 == o.field2 && 
//                (field3 == null ? o.field3 == null : (field3.equals(o.field3))));
    
        //Cách 2
        return (field1 == o.field1 && field2 == o.field2 && Objects.equals(field3, o.field3));
    }
    
}
public class example {

    public static void main(String[] args) {
        
    }
    
}
