import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;
    String address;

    public Contact(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}

public class ContactBook {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        contacts.add(new Contact(name, phone, email, address));
        System.out.println("Contact added successfully!");
    }

    public void viewContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            System.out.println((i + 1) + ". " + contact.name + " - " + contact.phone);
        }
    }

    public void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name or phone number to search: ");
        String searchTerm = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.name.contains(searchTerm) || contact.phone.contains(searchTerm)) {
                System.out.println("Name: " + contact.name + ", Phone: " + contact.phone + ", Email: " + contact.email + ", Address: " + contact.address);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found.");
        }
    }

    public void updateContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the contact to update: ");
        String nameToUpdate = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(nameToUpdate)) {
                System.out.print("Enter new phone number: ");
                contact.phone = scanner.nextLine();
                System.out.print("Enter new email: ");
                contact.email = scanner.nextLine();
                System.out.print("Enter new address: ");
                contact.address = scanner.nextLine();
                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the contact to delete: ");
        String nameToDelete = scanner.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).name.equalsIgnoreCase(nameToDelete)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nContact Book");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    updateContact();
                    break;
                case "5":
                    deleteContact();
                    break;
                case "6":
                    System.out.println("Exiting Contact Book.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        contactBook.run();
    }
}
