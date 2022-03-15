import java.util.Scanner;

public class CircleWithException {
    private double radius;

    public CircleWithException(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("ERROR: The radius should be more than 0");
        }
        this.radius = radius;
    }

    public double getRadius() {return radius;}

    public double getArea() {
        double area = Math.PI * this.radius * this.radius;
        if(area>1000){
            throw new IllegalArgumentException("ERROR: Area cannot be more than 1000");
        }
        return area;
    }

    public double getDiameter() {
        double diameter = 2 * this.radius;
        return diameter ;
    }

    public static void main(String[] args) {
        double rad = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("What is the radius of the circle: ");
        rad = scan.nextInt();

        try {
            CircleWithException circle = new CircleWithException(rad);
            System.out.println("The radius is " + circle.getRadius());
            System.out.println("The area is " + circle.getArea());
            System.out.println("The diameter is " + circle.getDiameter());
        }catch(IllegalArgumentException e){System.out.println(e.getMessage());}
    }
}
