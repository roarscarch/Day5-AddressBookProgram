import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public Contact(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

class AddressBook {

    private static final Scanner scanner = new Scanner(System.in);
    private ArrayList<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    void createNewContact() {
        System.out.print("Enter first name of the contact: ");
        String firstName = scanner.nextLine();

        // Check if a contact with the same first name already exists
        Contact existingContact = findContact(firstName);

        if (existingContact != null) {
            System.out.println("Contact with first name " + firstName + " already exists!");
        } else {
            Contact newContact = new Contact(firstName);
            contacts.add(newContact);
            System.out.println("New contact with first name " + firstName + " is created successfully");
        }
    }
     
    void displayAllContacts() {
        System.out.println("All Contacts:");
        for (Contact contact : contacts) {
            System.out.println("First Name: " + contact.getFirstName());
            System.out.println("Last Name: " + contact.getLastName());
            System.out.println("Address: " + contact.getAddress());
            System.out.println("City: " + contact.getCity());
            System.out.println("State: " + contact.getState());
            System.out.println("Zip: " + contact.getZip());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("-----------------------------");
        }
    }
  
    void editContact() {
        System.out.print("Enter first name of the contact to edit: ");
        String firstName = scanner.nextLine();

        // Check if a contact with the specified first name exists
        Contact existingContact = findContact(firstName);

        if (existingContact != null) {
            // Prompt user to edit details for the existing contact
            System.out.println("Editing contact with first name " + firstName + ":");
            System.out.print("Enter new last name (or press Enter to keep existing): ");
            String newLastName = scanner.nextLine();
            if (!newLastName.isEmpty()) {
                existingContact.setLastName(newLastName);
            }

            System.out.print("Enter new address (or press Enter to keep existing): ");
            String newAddress = scanner.nextLine();
            if (!newAddress.isEmpty()) {
                existingContact.setAddress(newAddress);
            }

            System.out.print("Enter new city (or press Enter to keep existing): ");
            String newCity = scanner.nextLine();
            if (!newCity.isEmpty()) {
                existingContact.setCity(newCity);
            }

            System.out.print("Enter new state (or press Enter to keep existing): ");
            String newState = scanner.nextLine();
            if (!newState.isEmpty()) {
                existingContact.setState(newState);
            }

            System.out.print("Enter new zip (or press Enter to keep existing): ");
            String newZip = scanner.nextLine();
            if (!newZip.isEmpty()) {
                existingContact.setZip(newZip);
            }

            System.out.print("Enter new phone number (or press Enter to keep existing): ");
            String newPhoneNumber = scanner.nextLine();
            if (!newPhoneNumber.isEmpty()) {
                existingContact.setPhoneNumber(newPhoneNumber);
            }

            System.out.println("Contact details updated successfully.");
        } else {
            System.out.println("Contact with first name " + firstName + " does not exist.");
        }
    }

    void deleteContact() {
        System.out.print("Enter first name of the contact to delete: ");
        String firstName = scanner.nextLine();

        // Check if a contact with the specified first name exists
        Contact existingContact = findContact(firstName);

        if (existingContact != null) {
            contacts.remove(existingContact);
            System.out.println("Contact with first name " + firstName + " deleted successfully.");
        } else {
            System.out.println("Contact with first name " + firstName + " does not exist.");
        }
    }

    void fillContactDetails() {
        System.out.print("Enter first name of the contact to fill details: ");
        String firstName = scanner.nextLine();

        // Check if a contact with the specified first name exists
        Contact existingContact = findContact(firstName);

        if (existingContact != null) {
            // Prompt user to enter details for the existing contact
            System.out.print("Enter last name: ");
            existingContact.setLastName(scanner.nextLine());

            System.out.print("Enter address: ");
            existingContact.setAddress(scanner.nextLine());

            System.out.print("Enter city: ");
            existingContact.setCity(scanner.nextLine());

            System.out.print("Enter state: ");
            existingContact.setState(scanner.nextLine());

            System.out.print("Enter zip: ");
            existingContact.setZip(scanner.nextLine());

            System.out.print("Enter phone number: ");
            existingContact.setPhoneNumber(scanner.nextLine());

            System.out.println("Details for contact with first name " + existingContact.getFirstName() + ":");
            System.out.println("Last Name: " + existingContact.getLastName());
            System.out.println("Address: " + existingContact.getAddress());
            System.out.println("City: " + existingContact.getCity());
            System.out.println("State: " + existingContact.getState());
            System.out.println("Zip: " + existingContact.getZip());
            System.out.println("Phone Number: " + existingContact.getPhoneNumber());
        } else {
            System.out.println("Contact with first name " + firstName + " does not exist. Use option 1 to create a new contact.");
        }
    }

    private Contact findContact(String firstName) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null;
    }
}



public class AddressBookProgram {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("-----------------------------");
            System.out.println("1. Create a new contact");
            System.out.println("2. Fill contact details");
            System.out.println("3. Display all contacts");
            System.out.println("4. Edit contact details");
            System.out.println("5. Delete a contact");
            System.out.println("6. Exit");
            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    addressBook.createNewContact();
                    break;
                case 2:
                    addressBook.fillContactDetails();
                    break;
                case 3:
                    addressBook.displayAllContacts();
                    break;
                case 4:
                    addressBook.editContact();
                    break;
                case 5:
                    addressBook.deleteContact();
                    break;
                case 6:
                    System.out.println("Exiting....");
                    System.exit(0);
                default:
                    System.out.println("Please enter the correct choice");
                    break;
            }
        }
    }
}
