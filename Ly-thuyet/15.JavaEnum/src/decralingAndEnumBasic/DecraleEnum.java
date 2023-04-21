/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package decralingAndEnumBasic;
//enum
public enum DecraleEnum{
    SPRING,
    SUMMER,
    FALL,
    WINTER
}
//Và cũng có thể khai báo trong một class khác
//Không được phép hằng số enum trùng lặp
/*
1. name()
2. valueOf()
*/
class Example{
    
    private Season season;
    
    public String getSeason() {
        return season.name();
    }
    
    public void setSeason(String season){
        this.season = Season.valueOf(season);
    }
    //Khai báo trong một class khác
    private enum Season{
        SPRING,
        SUMMER,
        FALL,
        WINTER
    }
    public static void main(String[] args) {
        Example e = new Example();
        e.setSeason("SPRING"); //chỉ có thể đưa các giá trị đã có trong enum Season
        System.out.println(e.getSeason());
        
        //
        System.out.println(e.season.SPRING);

        //Phương thức có sẵn name() giúp lấy tên của giá trị trong enum
        e.season = e.season.FALL;
        System.out.println(e.season.name());
        
        e.season = e.season.valueOf("WINTER");
        System.out.println(e.season.name());
    }
}


