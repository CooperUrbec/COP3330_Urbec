public class Cube extends Shape3D{
    private double length;

    public Cube(double length){
        this.length = length;
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
