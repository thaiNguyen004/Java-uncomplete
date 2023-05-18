
package arraysMethod;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod {
    public static void main(String[] args) {
        /*
            toString
            equals
            fill
            sort
            binarySearch
            copyOf
            asList
        */
        
        int[] number = {1,2,3,4,5,6,7,8,9};
        
        //toString
        System.out.println(Arrays.toString(number));
        //output: [1,2,3,4,5,6,7,8,9]
        
        //equals in Arrays
        int[] number2 = {1,2,3,4,5};
        int[] number3 = {1,2,3,4,5,6,7,8,9};
        
        System.out.println(Arrays.equals(number, number2)); //false
        System.out.println(Arrays.equals(number, number3)); //true
        
        
        //fill
        int[] number4 = {0,0,0,0,0,0};
        Arrays.fill(number4, 1); // [1,1,1,1,1,1] 
        
        //sort 
        int[] number5 = {5,4,3,2,1};
        Arrays.sort(number5); //[1,2,3,4,5]
        
        //binarySearch chỉ dùng được khi mảng đã được sắp xếp
        // trả về vị trí nếu tìm thấy
        int index = Arrays.binarySearch(number5, 5); // index = 4
        
        //copyOf
        String[] arr1 = {"Java", "Js", "C++"};
        String[] arrCopy = Arrays.copyOf(arr1, 5);
        /*newLength : là số lượng phần tử được tạo ra cho mảng arrCopy và chỉ 3 phần tử trong 
                      arrCopy được copy từ arr1
        */

        //copyOfRange
        String[] arr2 = {"JavaScript", "PHP", "Python"};
        String[] arr2Copy = Arrays.copyOfRange(arr2, 0, 2);
        //[JavaScript, PHP]
        
        
        //asList 
        /*Lưu ý: danh sách được trả về sẽ là danh sách cố định nếu muốn thay đổi 
        thì một ngoại lệ sẽ được ném ra exception*/
        
        Integer[] arr3 = {1,2,3,4,5,6};
        List<Integer> list = Arrays.asList(arr3);
        //list : [1,2,3,4,5,6]
        //cố tình thay đổi
        
    }
}
