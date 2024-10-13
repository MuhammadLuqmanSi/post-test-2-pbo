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
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan nama Pelanggan: ");
        String name = sc.nextLine();

        double weight = 0;
        while (true) {
            System.out.print("Masukan berat Laundry (kg): ");
            try {
                weight = sc.nextDouble();
                sc.nextLine(); 
                if (weight <= 0) {
                    System.out.println("masukan tidak kurang dari 0 ");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("input tidak benar masukan dengan benar beratnya.");
                sc.nextLine(); 
            }
        }

        String type = "";
        while (true) {
            System.out.print("Pilih type laundry (1. Express, 2. Regular): ");
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
                    System.out.println("pilihan tidak benar, masukan angka 1 atau 2.");
                }
            } catch (Exception e) {
                System.out.println("pilihan tidak benar, masukan angka 1 atau 2.");
                sc.nextLine(); 
            }
        }

        customers.add(new Customer(name, weight, type));
        System.out.println(type + " customer '" + name + "' added successfully.");
    }

    @Override
    public void updateCustomer() {
        if (customers.isEmpty()) {
            System.out.println("No customers available to update.");
            return;
        }

        viewCustomers();
        Scanner sc = new Scanner(System.in);
        System.out.print("masukan ID pelanggan yang ingin di update: ");
        int id = 0;
        try {
            id = sc.nextInt();
            sc.nextLine(); 
        } catch (Exception e) {
            System.out.println("input salah, masukan ID pelanggan yang benar.");
            sc.nextLine(); 
            return;
        }

        if (id > 0 && id <= customers.size()) {
            Customer customer = customers.get(id - 1);
            System.out.println("Updating Customer: " + customer.getName());

            // Update nama
            System.out.print("masukan nama baru (leave blank to keep '" + customer.getName() + "'): ");
            String newName = sc.nextLine();
            if (!newName.trim().isEmpty()) {
                customer = new Customer(newName, customer.getWeight(), customer.getType());
                customers.set(id - 1, customer);
                System.out.println("Name updated successfully.");
            }

            // Update berat
            System.out.print("masukan berat baru (kg) (current: " + customer.getWeight() + ", leave blank to keep): ");
            String weightInput = sc.nextLine();
            double newWeight = customer.getWeight();
            if (!weightInput.trim().isEmpty()) {
                try {
                    newWeight = Double.parseDouble(weightInput);
                    if (newWeight <= 0) {
                        System.out.println("Weight must be a positive number. Keeping previous weight.");
                        newWeight = customer.getWeight();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Keeping previous weight.");
                    newWeight = customer.getWeight();
                }
            }

            // Update Type
            System.out.print("pilih type laundry baru (1. Express, 2. Regular) (current: " + customer.getType() + ", leave blank to keep): ");
            String typeInput = sc.nextLine();
            String newType = customer.getType();
            if (!typeInput.trim().isEmpty()) {
                try {
                    int typeChoice = Integer.parseInt(typeInput);
                    if (typeChoice == 1) {
                        newType = "Express";
                    } else if (typeChoice == 2) {
                        newType = "Regular";
                    } else {
                        System.out.println("Invalid choice. Keeping previous type.");
                        newType = customer.getType();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Keeping previous type.");
                    newType = customer.getType();
                }
            }

            // Update Customer Data
            customers.set(id - 1, new Customer(
                newName.trim().isEmpty() ? customer.getName() : newName,
                newWeight,
                newType
            ));
            System.out.println("Customer data updated successfully.");
        } else {
            System.out.println("Invalid ID.");
        }
    }
}
