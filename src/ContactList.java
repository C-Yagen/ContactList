import java.util.ArrayList;
public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person newContact){
        contacts.add(newContact);
    }

    public void printContacts(){
        for (Person contact:contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy){
        // Sort by First Name
        if (sortBy < 0 || sortBy > 2){
            return;
        }
        Person temp;
        String contact1;
        String contact2;
            for (int i = 0; i < contacts.size() - 1; i++) {
                for (int j = 0; j < contacts.size() - 1 - i; j++) {
                    // If contacts(j) comes after contacts(j+1), then swap
                    if (sortBy == 0){
                        contact1 = contacts.get(j).getFirstName();
                        contact2 = contacts.get(j + 1).getFirstName();
                    } else if (sortBy == 1) {
                        contact1 = contacts.get(j).getLastName();
                        contact2 = contacts.get(j + 1).getLastName();
                    } else {
                        contact1 = contacts.get(j).getPhoneNumber();
                        contact2 = contacts.get(j + 1).getPhoneNumber();
                    }

                    if (contact1.compareTo(contact2) > 0){
                        temp = contacts.get(j + 1);
                        contacts.set(j + 1, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }

    }

    public Person searchByFirstName(String firstName){
        for (Person contact: contacts){
            if (contact.getFirstName().equals(firstName)){
                return contact;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName){
        for (Person contact: contacts){
            if (contact.getLastName().equals(lastName)){
                return contact;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber){
        for (Person contact: contacts){
            if (contact.getPhoneNumber().equals(phoneNumber)){
                return contact;
            }
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println("working");
        Person bob = new Person("bob", "b", "8129812398123");
        Person cob = new Person("cob", "f", "1129812398123");
        Person dob = new Person("dob", "z", "2129812398123");
        ContactList list = new ContactList();
        list.addContact(bob);
        list.addContact(dob);
        list.addContact(cob);
        list.printContacts();
        list.sort(2);
        list.printContacts();
    }
}