/**
 * Implementasi Class Main
 *
 * Kelompok 17
 * Nathanael Valen Susilo   -   5025231099
 * Basten Andika Salim      -   5025231132
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter book name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter book quantity: ");
                    int itemQuantity = scanner.nextInt();
                    scanner.nextLine();  
                    try {
                        inventory.tambahItem(itemName, itemQuantity);
                    } catch (IOException except) {
                        except.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.print("\nEnter the book name to remove: ");
                    String hapusItem = scanner.nextLine();
                    try {
                        inventory.hapusItem(hapusItem);
                    } catch (IOException except) {
                        except.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        inventory.tampilkanItem();
                    } catch (IOException except) {
                        except.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("\nExiting the program...");
                    break;

                default:
                    System.out.println("\nInvalid option. (Choose 1-4)");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n/-------------------------------------\\");
        System.out.println("|           INVENTORY MENU            |");
        System.out.println("|-------------------------------------|");
        System.out.println("| 1. Add Book                         |");
        System.out.println("| 2. Remove Book                      |");
        System.out.println("| 3. Display Books                    |");
        System.out.println("| 4. Exit                             |");
        System.out.println("\\-------------------------------------/");
    }
}
