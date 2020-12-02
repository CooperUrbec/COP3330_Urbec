import java.util.Scanner;

public class ContactApp{
    private Scanner scanner = new Scanner(System.in);
    private ContactList list;

    public void mainMenu(){
        int userInput;

        while(true){
            mainMenuOptions();
            userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){
                case 1:
                    createList();
                    break;
                case 2:
                    loadList();
                    break;
                case 3:
                    return;
                default :
                    System.out.println("Invalid input.\n");
                    break;
            }

        }
    }

    private void createList(){
        list = new ContactList();
        System.out.println("New Contact list has been created\n");
        listMenu();

    }

    private void loadList(){
        list = new ContactList();

        System.out.println("Enter the filename to load: ");
        String filePath = scanner.nextLine();

        if(list.loadList(filePath)){
            listMenu();
        }

    }

    private void listMenu(){
        int userInput;

        while(true){
            listMenuOptions();
            userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){

                case 1: //view list
                    list.printList();
                    break;

                case 2: //add item
                    addContact();
                    break;

                case 3: //edit item
                    editContact();
                    break;

                case 4: //remove item
                    removeContact();
                    break;

                case 5: //save list
                    saveContact();
                    break;

                case 6: //exit
                    return;
                default :
                    System.out.println("Invalid input.\n");
                    break;
            }

        }
    }

    private void saveContact(){
        System.out.printf("\nEnter the filename to save as: ");
        String filepath = scanner.nextLine();

        list.saveList(filepath);
    }

    private void removeContact() {
        System.out.printf("\nWhich contact will you remove? \n");
        list.printList();
        int index = scanner.nextInt();

        list.removeContact(index);
    }

    private void editContact() {
        System.out.printf("\nWhich contact will you edit? \n");
        list.printList();
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("\nEnter a new first name for contact %d: ", index);
        String newFirstName = scanner.nextLine();

        System.out.printf("Enter a new last name for contact %d: ", index);
        String newLastName = scanner.nextLine();

        System.out.printf("Enter a new phone number (xxx-xxx-xxxx) for contact %d: ", index);
        String newPhone = scanner.nextLine();

        System.out.printf("Enter a new email (x@y.z) for contact %d: ", index);
        String newEmail = scanner.nextLine();

        list.editContact(index, newFirstName, newLastName, newPhone, newEmail);

    }

    private void addContact() {

        System.out.printf("\nFirst name: ");
        String firstName = scanner.nextLine();

        System.out.printf("Last name: ");
        String lastName = scanner.nextLine();

        System.out.printf("Phone number (xxx-xxx-xxxx): ");
        String phone = scanner.nextLine();

        System.out.printf("Email address (x@y.z): ");
        String email = scanner.nextLine();

        list.addContact(firstName, lastName, phone, email);
    }

    private void mainMenuOptions(){
        System.out.printf("\nMain Menu");
        System.out.printf("\n---------");
        System.out.printf("\n\n1) create a new list");
        System.out.printf("\n2) load an existing list");
        System.out.printf("\n3) quit\n");
    }

    private void listMenuOptions(){
        System.out.printf("\nList Operation Menu");
        System.out.printf("\n---------");
        System.out.printf("\n\n1) view the list");
        System.out.printf("\n2) add a contact");
        System.out.printf("\n3) edit a contact");
        System.out.printf("\n4) remove an item");
        System.out.printf("\n5) save current list");
        System.out.printf("\n6) exit to main menu\n");
    }
}
