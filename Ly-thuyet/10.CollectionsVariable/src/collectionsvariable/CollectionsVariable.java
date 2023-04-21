/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package collectionsvariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *  sort(): Sắp xếp các phần tử của List theo thứ tự được chỉ định
    reverse(): Đảo ngược thứ tự của các phần tử trong List
    shuffle(): Xáo trộn các phần tử trong List
    binarySearch(): Tìm kiếm một phần tử trong List bằng thuật toán tìm kiếm nhị phân
    replaceAll(): Thay thế toàn bộ phần tử có giá trị bằng một giá trị mới trong List
    frequency(): Đếm số lần xuất hiện của một đối tượng trong List
    disjoint(): Kiểm tra hai collection có phần tử chung hay không
    copy(): Sao chép các phần tử từ một List khác vào List đang xét
    max(): Trả về phần tử lớn nhất trong Collection
    min(): Trả về phần tử nhỏ nhất trong Collection
 * @author nguye
 */
public class CollectionsVariable {
    public static void main(String[] args) {
        //sort
        //List l = new List() Không nên dùng
        
        List l = new ArrayList();
        l.add("Apple");l.add("Banana");l.add("Orange");l.add("Fruit");
        Collections.sort(l); // sắp xếp tăng dần
        //[Apple, Banana, Fruit, Orange]
        
        //sort2 sắp xếp tùy ý 
        //Giảm dần thì return = -1
        Collections.sort(l,(o1, o2) -> -1);
        //[Orange, Fruit, Banana, Apple]
        
        
        //Cách viết thứ hai
        Collections.sort(l, (o1,o2)->{
            return -1;
        });
        System.out.println(l.toString());
             
        
        
        
        
        //reverse 
        List l2 = new ArrayList();
        l2.add(l);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        Collections.reverse(l2);
        System.out.println(l2);
        //[4, 3, 2, [Apple, Banana, Fruit, Orange]]
        
//      shuffle
        List l3 = new ArrayList();
        l3.add(1);
        l3.add(2);
        l3.add(3);
        l3.add(4);
        l3.add(5);
        //Tạo ra một đối tượng random
        Random rand = new Random();
        Collections.shuffle(l3,rand);
        System.out.println(l3.toString());
        
        
        //replaceAll
        List list = new ArrayList();
        list.add("Con chó");
        list.add("Con mèo");
        list.add("Con mèo");
        list.add("Con vịt");
        Collections.replaceAll(list, "Con mèo", "Con cặc");
        System.out.println(list.toString());
        
        //frequency()
        int count = Collections.frequency(list, "Con chó"); // return 1
        System.out.println(count);
        
        //disjoint
        List listOne = new ArrayList();
        List listTwo = new ArrayList();
        listOne.add("1");
        listOne.add("2");
        listOne.add("3");
        
        listTwo.add("1");
        listTwo.add("4");
        listTwo.add("2");
        
        //Có 2 điểm chung là 1 và 2 nên trả về false, không có điểm chung thì tv true
        System.out.println(Collections.disjoint(listOne, listTwo));
        
        List SuperList = new ArrayList();
        SuperList.add(1);
        SuperList.add(2);
        SuperList.add(3);
        SuperList.add(4);
        SuperList.add(5);
        //Ban đầu list muốn copy phải có số phần tử đủ chứa phần tử của List cha
        
        List subList = new ArrayList(Collections.nCopies(SuperList.size(), ""));
        Collections.copy(subList, SuperList);
        System.out.println(subList.toString());
        
        //Max trong SuperList = 5
        //Min trong SuperList = 1
        System.out.println(Collections.max(SuperList));
        System.out.println(Collections.min(SuperList));
    }
    
}
