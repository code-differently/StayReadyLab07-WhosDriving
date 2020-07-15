import Driving.Drivable;
import Vehicles.HondaCivic;
import Vehicles.MountainBike;

import java.util.Scanner;

public class App {
    static int appExecutionStatus = -1;

    /**
     * main App, runs the application
     * If the first element of args is "test" then the
     * app will run using a scanner that is made of
     * input passed into the second element
     *
     * If no errors occur, then the final line of the method
     * will change the appExecutionStatus variable to 0;
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (args[0].equals("test"))
            in = new Scanner(args[1]);
        Console c = new Console(in);

        System.out.println("What kinda of vehicle do you want to drive");
        Drivable vehicle = getVehicle(c);

        System.out.println("How far do you want to travel");
        Double distance = getDistance(c);

        Integer timeTraveled = vehicle.transport(distance);

        System.out.println(String.format("You traveled for %d seconds", timeTraveled));
        App.appExecutionStatus = 0;
    }

    /**
     * This method should return a new instance of a Drivable.
     * The input received should be representative of a class
     * that implements Drivable. E.G. the input "honda civic"
     * should return an instance of a HondaCivic
     *
     * @param c
     * @return input from Console c as Drivable
     */
    public static Drivable getVehicle(Console c) {
        String input = c.getInput();
        String[] words = input.split(" ");
        StringBuilder str = new StringBuilder();
        for(String word: words) {
            //capitalizes the first letter of the word and then appends the rest. There is no space in between
            str.append(word.substring(0, 1).toUpperCase() + word.substring(1));
        }
        if(str.toString().equals("HondaCivic")) {
            return new HondaCivic();
        }
        else if(str.toString().equals("MountainBike")) {
            return new MountainBike();
        }
        return null;
    }

    /**
     * This method get input from the console and convert it to
     * a double. This double represents a distance a user wants
     * to travel in a specified vehicle.
     * @param c
     * @return Input from Console c as Double
     */
    public static Double getDistance(Console c) {
        String input = c.getInput();
        Double ans = Double.parseDouble(input);
        return ans;
    }
}
