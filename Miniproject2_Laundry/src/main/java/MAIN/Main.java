/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package MAIN;
import Service.LaundryService;
import Service.LaundryManager;
import java.util.Scanner;
/**
 *
 * @author Luqman
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LaundryService laundryService = new LaundryManager();
        
        while (true) {
            System.out.println("\n=== Laundry Management System ===");
            System.out.println("1. Tambahkan Customer");
            System.out.println("2. Tampilkan data Customers");
            System.out.println("3. Delete Customer");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                sc.nextLine(); 
                continue;
            }

            switch (choice) {
                case 1:
                    laundryService.addCustomer();
                    break;
                case 2:
                    laundryService.viewCustomers();
                    break;
                case 3:
                    laundryService.deleteCustomer();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose between 1 and 4.");
            }
        }
    }
}

