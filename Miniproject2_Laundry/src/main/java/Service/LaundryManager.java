/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import model.Customer;
import java.util.Scanner;
/**
 *
 * @author Luqman
 */
public class LaundryManager extends LaundryService {

    public LaundryManager() {
        customers.add(new Customer("Andi", 4.5, "Regular"));
        customers.add(new Customer("Budi", 3.2, "Express"));
        customers.add(new Customer("Citra", 5.0, "Regular"));
        customers.add(new Customer("Dewi", 2.5, "Express"));
    }

    @Override
    public void addCustomer() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        double weight = 0;
        while (true) {
            System.out.print("Enter laundry weight (kg): ");
            try {
                weight = sc.nextDouble();
                sc.nextLine(); 
                if (weight <= 0) {
                    System.out.println("Weight must be a positive number.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value for weight.");
                sc.nextLine(); // Clear buffer
            }
        }

        String type = "";
        while (true) {
            System.out.print("Choose laundry type (1. Express, 2. Regular): ");
            int typeChoice = 0;
            try {
                typeChoice = sc.nextInt();
                sc.nextLine(); 
                if (typeChoice == 1) {
                    type = "Express";
                    break;
                } else if (typeChoice == 2) {
                    type = "Regular";
                    break;
                } else {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                sc.nextLine(); 
            }
        }

        customers.add(new Customer(name, weight, type));
        System.out.println(type + " customer '" + name + "' added successfully.");
    }
}

