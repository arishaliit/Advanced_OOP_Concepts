import java.lang.reflect.Field;
import java.util.Objects;

/* TODO : Complete the Square class.
 Add variables if you need.
 Remember to use the @Override to override methods.
intelliJ will be helpful if you do).*/
public class Square extends Shape {

    private double side;

    public Square(double side, String name) {
        super(name);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPerimeter() {
        return side*4;
    }

    @Override
    public boolean equals(Object o) {

        boolean isEqual = false;

        if(o instanceof Square){

            Square square = (Square) o;

            if(square.getName().equals(this.getName())){

                if(square.side == side){
                    isEqual = true;
                }
            }

        }

        return isEqual;
    }

    @Override
    public String toString() {
        return name + ":" + side;
    }
}