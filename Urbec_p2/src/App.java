import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }


    private static boolean moreInput(){
        Scanner scanner = new Scanner(System.in);

        String userIn = " ";

        while(!userIn.equals("Y") && !userIn.equals("N")){
            System.out.println("Do you have more input, enter 'Y' for yes or 'N' for no: ");
            userIn = scanner.nextLine();
            userIn = userIn.toUpperCase();
        }

        return userIn.equals("Y");
    }

    private static double getUserHeight(){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter your height in inches: ");

            if(scanner.hasNextDouble()) return scanner.nextDouble();
            scanner.next();
        }
    }

    private static double getUserWeight(){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter your weight in inches: ");

            if(scanner.hasNextDouble()) return scanner.nextDouble();
            scanner.next();
        }
    }

    private static void displayBmiInfo(BodyMassIndex bmi){

        double bmiScore = bmi.calculateBMI();

        if(bmiScore < 18.5){ //underweight
            System.out.println("Your BMI score is " + bmiScore + ", you are underweight.");
        }
        else if(bmiScore <= 24.9){ //normal weight
            System.out.println("Your BMI score is " + bmiScore + ", you are a normal weight.");
        }
        else if(bmiScore <= 29.9){ //overweight
            System.out.println("Your BMI score is " + bmiScore + ", you are overweight.");
        }
        else{ //obesity
            System.out.println("Your BMI score is " + bmiScore + ", you are obese.");
        }
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){

        double bmiAve = 0;

        for(BodyMassIndex bmi: bmiData){
            bmiAve += bmi.calculateBMI();
        }

        bmiAve = bmiAve / bmiData.size();

        System.out.println("The average BMI score is " + bmiAve);

    }
}
