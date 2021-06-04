package ex19;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Veronica Martucci
 */
import java.util.Scanner;

public class App {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        App app = new App();
        double height = app.inputHeight();
        double weight = app.inputWeight();
        double BMI = app.calculateBMI(weight, height);
        app.generateOutput(BMI);
        app.checkBMIHealth(BMI);
    }

    public boolean isNum(String str){

        if(str == null || str.length() == 0){
            return false;
        }
        try{
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public double inputHeight() {
        boolean boo1 = true;
        String str;
        double height = 0.0;

        while (boo1) {
            System.out.print("Enter your height in inches: ");
            str = input.next();

            boolean boo = isNum(str);

            if (boo1 != boo) {
                System.out.println("Error, invalid input. Try again");
            } else {
                height = Double.parseDouble(str);
                boo1 = false;
            }
        }
        return height;
    }

    public double inputWeight() {
        boolean boo1 = true;
        String str;
        double weight = 0.0;

        while (boo1) {
            System.out.print("Enter your weight in pounds: ");
            str = input.next();

            boolean boo = isNum(str);

            if (boo1 != boo) {
                System.out.println("Error, invalid input. Try again");
            } else {
                weight = Double.parseDouble(str);
                boo1 = false;
            }
        }
        return weight;
    }

   public double calculateBMI(double weight, double height){
        return (weight / (height * height)) * 703;
    }

    public void checkBMIHealth(double BMI){
        if(BMI >= 18.5 && BMI <= 25){
            System.out.println("You are within the ideal weight range.");
        }
        else if(BMI < 18.5){
            System.out.println("You are underweight. You should see your doctor.");
        }
        else if(BMI > 25){
            System.out.println("You are overweight. You should see your doctor.");
        }
    }

    public void generateOutput(double BMI){
        System.out.printf("Your BMI is %.1f\n", BMI);
    }
}
