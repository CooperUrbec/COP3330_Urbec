public class Sphere extends Shape3D{
    private double radius;

    public Sphere(double radius){
        this.radius = radius;
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
