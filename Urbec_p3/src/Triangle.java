public class Triangle extends Shape2D{
    private double base;
    private double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
