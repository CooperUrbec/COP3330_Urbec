public class ContactItem {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String eMail;

    public static ContactItem newContactItemInstance(String firstName, String lastName, String phoneNumber, String eMail){

        if(isInValidInput(firstName, lastName, phoneNumber, eMail)){
            return null;
        }

        return new ContactItem(firstName, lastName, phoneNumber, eMail);
    }

    private ContactItem(String firstName, String lastName, String phoneNumber, String eMail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public void editContact(String firstName, String lastName, String phoneNumber, String eMail){

        if(isInValidInput(firstName, lastName, phoneNumber, eMail)){
            return;
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getEmail(){
        return this.eMail;
    }

    @Override
    public String toString(){
        return "Name: " + this.firstName + " " + this.lastName +
                "\nPhone: " + this.phoneNumber +
                "\nEmail: " + this.eMail;
    }

    private static boolean isInValidInput(String firstName, String lastName, String phoneNumber, String eMail){

        if(firstName.equals("") &&
                lastName.equals("") &&
                phoneNumber.equals("") &&
                eMail.equals("")) {
            System.out.println("WARNING: invalid input, at least one field must not be empty.");
            return true;
        }

        return false;
    }
}
