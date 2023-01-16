
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //Global ArrayList
    static ArrayList<Double> list = new ArrayList<>();

    //start \ main
    public static void main(String[] args) {
        System.out.println("Welcome to currency converter");
        currencyConverter();
    }

    //handles errors and contains the calculations
    private static void currencyConverter(){
        try {
            start();
            end();

        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("Invalid choice, Please try again");
            currencyConverter();
        }
    }

    //first steps (choosing currency) and converting
    private static void start(){
        CoinFactory coinFactory = new CoinFactory();
        Coin ILS = coinFactory.getCoin("ILS");
        Coin USD = coinFactory.getCoin("USD");

        Scanner a = new Scanner(System.in);

        System.out.println("Please choose an option (1/2):");
        System.out.println("1.Dollars to Shekels");
        System.out.println("2.Shekels to Dollars");
        int choice = a.nextInt();

        if (choice == 1) {

            System.out.println("Please enter an amount to convert:");
            double amount = a.nextInt();

            double shekel = ILS.calculate(amount);
            System.out.println(amount + " Dollars is " + shekel + " Shekels");

            //Add result to list
            list.add(shekel);

        } else if (choice == 2) {

            System.out.println("Please enter an amount to convert:");
            double amount = a.nextInt();

            double dollar = USD.calculate(amount);
            System.out.println(amount + " Shekels is " + dollar + " Dollars");

            //Add result to list
            list.add(dollar);

        } else {
            System.out.println("Invalid choice, please try again");
            start();
            end();
        }
    }

    //Result and end screens
    private static void end(){

        Scanner b = new Scanner(System.in);
        System.out.println("Would you like to start over? (Y/N)");
        String ans = b.next();

        if (ans.equalsIgnoreCase("Y")) {
            start();
            end();

        } else if (ans.equalsIgnoreCase("N")) { //print the list create Txt file and write into it
            String listContent="";
            System.out.println("Your converted values are:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
                listContent=listContent + list.get(i) +"\n";
            }
            try{
                String filePath="result.txt";
                Files.writeString(Paths.get(filePath), listContent);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("Thanks for using our currency converter");

        } else{

            System.out.println("Invalid choice, please try again");
            end();
        }
    }
}