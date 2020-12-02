import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactList list = new ContactList();

        int sizeBeforeAdd = list.size();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");

        assert(list.size() != sizeBeforeAdd);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        ContactItem itemBeforeEdit = list.getContact(0);

        list.editContact(0, "", "", "", "");

        assert(itemBeforeEdit.toString().equals(list.getContact(0).toString()));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        ContactItem itemBeforeEdit = list.getContact(0);

        list.editContact(4, "jim", "bill", "999-999-9999", "jim@gmail.com");

        assert(itemBeforeEdit.toString().equals(list.getContact(0).toString()));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        String lastName = list.getContact(0).getLastName();

        list.editContact(0, "", "bill", "999-999-9999", "jim@gmail.com");

        assert(!lastName.equals(list.getContact(0).getLastName()));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        String firstName = list.getContact(0).getFirstName();

        list.editContact(0, "jim", "", "999-999-9999", "jim@gmail.com");

        assert(!firstName.equals(list.getContact(0).getFirstName()));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        String firstName = list.getContact(0).getFirstName();

        list.editContact(0, "jim", "bill", "", "jim@gmail.com");

        assert(!firstName.equals(list.getContact(0).getFirstName()));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        String firstName = list.getContact(0).getFirstName();

        list.editContact(0, "jim", "bill", "999-999-9999", "jim@gmail.com");

        assert(!firstName.equals(list.getContact(0).getFirstName()));
    }

    @Test
    public void newListIsEmpty(){
        ContactList list = new ContactList();

        assert(list.size() == 0);
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        list.addContact("jim", "bill", "999-999-9999", "jim@gmail.com");
        int sizeBeforeRemove = list.size();

        list.removeContact(0);

        assert(sizeBeforeRemove != list.size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        list.addContact("jim", "bill", "999-999-9999", "jim@gmail.com");
        int sizeBeforeRemove = list.size();

        list.removeContact(5);

        assert(sizeBeforeRemove == list.size());
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList list = new ContactList();

        list.addContact("bob", "fill", "888-888-8888", "bob@gmail.com");
        list.saveList("saveTest.txt");

        ContactList list2 = new ContactList();
        list2.loadList("saveTest.txt");

        assert(list.getContact(0).toString().equals(list2.getContact(0).toString()));
    }

}