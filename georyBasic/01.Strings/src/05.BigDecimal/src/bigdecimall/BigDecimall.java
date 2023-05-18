/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bigdecimall;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimall {

    /**Tại sao phải sử dụng BigDecimal thay vì dùng float double
     * Vì: trong quá trình tính toán dài float và double rất dễ và hoàn toàn có
     * khả năng tạo ra sai số trong tính toán, nếu bạn làm việc trong các lĩnh vực 
     * kế toán hoặc tính tiền tệ thì điều này không thể chấp nhận được
     * Do dó: nên sử dụng BigDecimal vì nó khắc phục được điều này
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Khởi tạo đối tượng cơ bản
        BigDecimal bd = new BigDecimal("3.8888");
        // bd : 3.8888
        
        //valueOf  -  Chuyển một String/double/float/int về BigDecimal
        BigDecimal bd2 = new BigDecimal(0);
        int a = 5;
        double b = 4.1414;
        
        System.out.println(bd2.valueOf(a));//bd2 : 5
        System.out.println(bd2.valueOf(b));//bd2 : 4.1414
        
        
        
        BigDecimal value1 = new BigDecimal("5");
        BigDecimal value2 = new BigDecimal("8");
        
        //add - tính tổng
        BigDecimal addNumber = value1.add(value2);
        //return 13
        
        //subtract  - tính hiệu
        BigDecimal subtractNumber = value2.subtract(value1);
        //return 3
        
        //multiply  - tính nhân
        BigDecimal multiplyNumber = value1.multiply(value2);
        //return 40 
        
        //divide  - tính chia
        BigDecimal divideNumber = value2.divide(value1);
        //return 1.6
        
        //pow
        BigDecimal powNumber = value1.pow(2);
        //return 25
        
        //abs
        BigDecimal absNumber = new BigDecimal("-1").abs();
        //return 1
        
        //intValue, floatValue, doubleValue
        BigDecimal number = new BigDecimal("3.5259275729575759");
        System.out.println(number);                 //return 3.5259275729575759
        System.out.println(number.intValue());      //return 3
        System.out.println(number.floatValue());    //return 3.5259275
        System.out.println(number.doubleValue());   //return 3.525927572957576
        
        
        //setScale để set số có bao nhiêu số sau dấu thập phân kết hợp với làm tròn : RoundingMode
        BigDecimal scaleNumber = new BigDecimal("10.065");
        
        BigDecimal result1 = scaleNumber.setScale(2, RoundingMode.UP);
        System.out.println(result1); 
        
        BigDecimal result2 = scaleNumber.setScale(2, RoundingMode.DOWN);
        System.out.println(result2);
        
        BigDecimal result3 = scaleNumber.setScale(2, RoundingMode.CEILING);
        System.out.println(result3);
        
        BigDecimal result4 = scaleNumber.setScale(2, RoundingMode.FLOOR);
        System.out.println(result4);
        
        //HALF_UP Làm tròn lên nếu số thập phân đằng sau >= 5 còn lại làm tròn xuống
        BigDecimal result5 = scaleNumber.setScale(2, RoundingMode.HALF_UP);
        System.out.println(result5);
        
        //HALF_DOWN Làm tròn xuống nếu số thập phân đằng sau <= 5 còn lại làm tròn lên
        BigDecimal result6 = scaleNumber.setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(result6);
        
        //HALF_EVEN Làm tròn đến số chẵn gần nhất
        String str1 = "8.1135552";
//        BigDecimal result7 = new BigDecimal();
        
    }
    
}
