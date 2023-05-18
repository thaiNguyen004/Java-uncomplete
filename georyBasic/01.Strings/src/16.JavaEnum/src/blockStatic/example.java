/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package blockStatic;

/**
 *
 * @author nguye
 */
public class example {
    
    public enum direction{
        NORTH, SOUTH, EAST, WEST;
        public direction getOpposite(){
            switch(this){
                case NORTH->{
                    return SOUTH;
                }
                case SOUTH->{
                    return NORTH;
                }
                case EAST->{
                    return WEST;
                }
                case WEST->{
                    return EAST;
                }
                default->{
                    return null;
                }
            }
        }
    }
    
    //using block static
    public enum directionUsingStaticBlockMethod{
        NORTH, SOUTH, EAST, WEST;
        private directionUsingStaticBlockMethod opposite;
        public directionUsingStaticBlockMethod getOpposite(){
            return this.opposite;
        }
        static {
            NORTH.opposite = SOUTH;
            SOUTH.opposite = NORTH;
            EAST.opposite = WEST;
            WEST.opposite = EAST;
        }
    }
    public enum season{
        SPRING,
        SUMMER,
        FALL,
        WINTER;
        private int value;
        public int getValue(){
            return value;
        }
        static {
            SPRING.value = 1;
            SUMMER.value = 2;
            FALL.value = 3;
            WINTER.value = 4;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(direction.NORTH.getOpposite());
        
        System.out.println(directionUsingStaticBlockMethod.NORTH.getOpposite());
        
        System.out.println("Value of "+season.SPRING.name()+" is "+season.SPRING.getValue());
    }
    
}
