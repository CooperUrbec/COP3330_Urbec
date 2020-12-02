import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        ContactItem item = ContactItem.newContactItemInstance("", "", "", "");

        assertNull(item);
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "");

        assert(item != null);
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem item = ContactItem.newContactItemInstance("", "fill", "888-888-8888", "bob@gmial.com");

        assert(item != null);
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "", "888-888-8888", "bob@gmial.com");

        assert(item != null);
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "", "bob@gmial.com");

        assert(item != null);
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmial.com");

        assert(item != null);
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmial.com");
        String itemBeforeEdit = item.toString();

        item.editContact("", "", "", "");

        assert(itemBeforeEdit.equals(item.toString()));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmial.com");
        String itemBeforeEdit = item.toString();

        item.editContact("jim", "grant", "180-999-6969", "");

        assert(!itemBeforeEdit.equals(item.toString()));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmial.com");
        String itemBeforeEdit = item.toString();

        item.editContact("", "grant", "180-999-6969", "jim@gmail.com");

        assert(!itemBeforeEdit.equals(item.toString()));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmial.com");
        String itemBeforeEdit = item.toString();

        item.editContact("jim", "", "180-999-6969", "jim@gmail.com");

        assert(!itemBeforeEdit.equals(item.toString()));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmial.com");
        String itemBeforeEdit = item.toString();

        item.editContact("jim", "grant", "", "jim@gmail.com");

        assert(!itemBeforeEdit.equals(item.toString()));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmial.com");
        String itemBeforeEdit = item.toString();

        item.editContact("jim", "grant", "180-999-6969", "jim@gmail.com");

        assert(!itemBeforeEdit.equals(item.toString()));
    }

    @Test
    public void testToString(){
        String expectedOutput = "Name: bob fill\n" +
                                "Phone: 888-888-8888\n" +
                                "Email: bob@gmail.com";

        ContactItem item = ContactItem.newContactItemInstance("bob", "fill", "888-888-8888", "bob@gmail.com");

        assert(item.toString().equals(expectedOutput));
    }

}