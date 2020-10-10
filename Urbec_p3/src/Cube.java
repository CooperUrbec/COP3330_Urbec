public class Cube extends Shape3D{
    private double length;

    public Cube(double length){
        this.length = length;
    }

    @Override
    public double getVolume() {
        return length * length * length;
    }

    @Override
    public String getName() {
        return "Cube";
    }

    @Override
    public double getArea() {
        return 6.0 * (length * length);
    }
}
