
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import model.Student;


public class MapDemo {

    public static void main(String[] args) {
        Map<String, Student> map = new LinkedHashMap<>();
        Student student = new Student("PH33935", "Nguyên", 9, "Phát triển phần mềm", true);
        map.put(student.getName(), student);
        
        //Cách 1 duyệt map
        Set<String> setKey = map.keySet();
        for (String key : setKey) {
            Student o = map.get(key);
            System.out.println("ID: "+ o.getId());
            System.out.println("Name: "+ o.getName());
            System.out.println("Mark: "+ o.getMarks());
            System.out.println("Major: "+ o.getMajor());
            System.out.println("Grade: "+ o.getGrade());
            System.out.println("Have Gift: "+ o.isHaveGift());
        }
        
        //Cách 2 duyệt map
        for (Map.Entry<String, Student> entry : map.entrySet()) {
            System.out.println("Name: "+entry.getKey());
            System.out.println("ID: "+entry.getValue().getId());
            System.out.println("Mark: "+entry.getValue().getMarks());
            System.out.println("Major: "+entry.getValue().getMajor());
            System.out.println("Grade: "+entry.getValue().getGrade());
            System.out.println("Have Gift: "+entry.getValue().isHaveGift());
        }
    }
    
}
