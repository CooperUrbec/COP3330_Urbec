import java.lang.Math;

public class BodyMassIndex {
    private double height;
    private double weight;

    public BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI(){
        double ret = (703 * this.weight) / (this.height * this.height);

        //round ret tone decimal place
        ret *= 10;
        ret = Math.round(ret);
        ret /= 10;

        return ret;
    }
}
