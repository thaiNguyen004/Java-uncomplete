/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package model;

public class Student {
    private String id;
    private String name;
    private double marks;
    private String major;
    private boolean haveGift;

    public Student(String id, String name, double marks, String major, boolean haveGift) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.major = major;
        this.haveGift = haveGift;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getMajor() {
        return major;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setHaveGift(boolean haveGift) {
        this.haveGift = haveGift;
    }
    
    public boolean isHaveGift() {
        return haveGift;
    }
    
    public String getGrade() {
        if(marks >= 9) return "Xuất sắc";
        if(marks >= 8) return "Giỏi";
        if(marks >= 6.5) return "Khá";
        if(marks >= 5) return "Trung bình";
        if(marks >= 3) return "Yếu";
        return "Kém";
    }
    
}
