public class Pyramid extends Shape3D{
    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double height, double width){
        this.length = length;
        this.height = height;
        this.width = width;
    }

    @Override
    public double getVolume() {
        return 0;
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
