import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ContactList {

    private ArrayList<ContactItem> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public void addContact(String firstName, String lastName, String phoneNumber, String email){

        ContactItem temp = ContactItem.newContactItemInstance(firstName, lastName, phoneNumber, email);

        if(temp == null) return;

        contacts.add(temp);
    }

    public void removeContact(int index){

        if(validIndex(index)){
            contacts.remove(index);
        }
    }

    public void editContact(int index, String firstName, String lastName, String phoneNumber, String email){

        if(validIndex(index)){
            contacts.get(index).editContact(firstName, lastName, phoneNumber, email);
        }
    }

    public ContactItem getContact(int index){

        if(validIndex(index)){
            return contacts.get(index);
        }

        return null;
    }

    public int size(){
        return contacts.size();
    }

    public void saveList(String filePath){
        try(Formatter formatter = new Formatter(filePath)){

            for(ContactItem contact: contacts){

                formatter.format("%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(),
                                                  contact.getPhoneNumber(), contact.getEmail());
            }
            System.out.println("List successfully saved.");
        }
        catch(FileNotFoundException e){
            System.out.println("WARNING: file not found.");
        }
    }

    public boolean loadList(String filePath){
        File file = new File(filePath);
        try(Scanner scanner = new Scanner(file)){

            while(scanner.hasNextLine()){
                String[] contact = scanner.nextLine().split(";", -2);
                this.addContact(contact[0], contact[1], contact[2], contact[3]);
            }
            System.out.println("List successfully loaded");
            return true;
        }
        catch(FileNotFoundException e){
            System.out.println("WARNING: file not found.");
            return false;
        }
    }

    public void printList(){

        for(int i = 0; i < contacts.size(); ++i){
            System.out.println(i + ") " + contacts.get(i).toString());
        }

    }

    private boolean validIndex(int index){

        if(index >= 0 && index < contacts.size()){
            return true;
        }

        System.out.println("WARNING: invalid index.");
        return false;
    }
}
