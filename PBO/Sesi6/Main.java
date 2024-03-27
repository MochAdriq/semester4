

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Laptop lenovo = new Lenovo();
        Laptop toshiba = new Toshiba();
        Laptop macbook = new MacBook();
        
        System.out.println("Welcome to Laptop Control System!");
        System.out.println("Available commands: ON, OFF, UP, DOWN");
        System.out.println("Please specify the laptop you want to control: Lenovo, Toshiba, MacBook");
        String laptopChoice = scanner.nextLine().toLowerCase();
        
        Laptop selectedLaptop;
        
        switch (laptopChoice) {
            case "lenovo":
                selectedLaptop = lenovo;
                break;
            case "toshiba":
                selectedLaptop = toshiba;
                break;
            case "macbook":
                selectedLaptop = macbook;
                break;
            default:
                System.out.println("Invalid laptop choice.");
                return;
        }
        
        LaptopUser user = new LaptopUser(selectedLaptop);
        
        while (true) {
            System.out.println("Enter command (ON, OFF, UP, DOWN) or 'EXIT' to quit:");
            String command = scanner.nextLine().toUpperCase();
            
            switch (command) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                case "OFF":
                    user.turnOffLaptop();
                    break;
                case "UP":
                    user.makeLaptopLouder();
                    break;
                case "DOWN":
                    user.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
