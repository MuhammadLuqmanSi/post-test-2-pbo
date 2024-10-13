/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import model.Customer;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Luqman
 */
public abstract class LaundryService implements crud {
    protected final ArrayList<Customer> customers = new ArrayList<>();

    // Abstract method for adding a customer
    @Override
    public abstract void addCustomer();

    // Abstract method for updating a customer
    @Override
    public abstract void updateCustomer();  // Menambahkan metode abstrak update

    // Final method to display customers
    @Override
    public final void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            System.out.println("\nCustomer List:");
            System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "Name", "Weight(kg)", "Type");
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                System.out.printf("%-5d %-20s %-10.2f %-10s\n", i + 1, customer.getName(), customer.getWeight(), customer.getType());
            }
        }
    }

    @Override
    public final void deleteCustomer() {
        if (customers.isEmpty()) {
            System.out.println("No customers to delete.");
            return;
        }

        viewCustomers();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the customer ID to delete: ");
        int id = 0;
        try {
            id = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid customer ID.");
            sc.nextLine(); // Clear buffer
            return;
        }

        if (id > 0 && id <= customers.size()) {
            Customer removed = customers.remove(id - 1);
            System.out.println("Customer '" + removed.getName() + "' removed successfully.");
        } else {
            System.out.println("Invalid ID.");
        }
    }
}