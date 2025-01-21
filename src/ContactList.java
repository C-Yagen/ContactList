import java.util.ArrayList;
import java.util.Scanner;

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

    public void listStudents(){
        for (Person p:contacts){
            if (p instanceof Student){
                System.out.println(p);
            }
        }
    }

    public void run(){
        int input = -1;
        Scanner s = new Scanner(System.in);
        System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last Name\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First Name\n7. Search By Last Name\n8. Search By Phone Number\n0. Exit");
        while (input != 0){
            System.out.println("New Input: ");
            input = s.nextInt();
            if (input == 1){
                s.nextLine();
                System.out.println("First Name:");
                String firstName = s.nextLine();
                System.out.println("Last Name:");
                String lastName = s.nextLine();
                System.out.println("Phone Number:");
                String phoneNumber = s.nextLine();
                System.out.println("Is this person a student?(true/false)");
                if (s.nextBoolean()){
                    System.out.println("Grade:");
                    int grade = s.nextInt();
                    contacts.add(new Student(firstName, lastName, phoneNumber, grade));
                    continue;
                }
                System.out.println("Is this person a friend?(true/false)");
                if (s.nextBoolean()){
                    System.out.println("Is this person a Best Friend?(true/false)");
                    boolean bestFriend = s.nextBoolean();
                    contacts.add(new Friend(firstName, lastName, phoneNumber, bestFriend));
                    continue;
                }
                contacts.add(new Person(firstName, lastName, phoneNumber));
            }
            else if (input > 1 && input < 5) {
                sort(input-2);
                printContacts();
            }
            else if (input == 5) {
                listStudents();
            }
            else if (input == 6){
                s.nextLine();
                System.out.println("First Name: ");
                System.out.println(searchByFirstName(s.nextLine()));
            }
            else if (input == 7){
                s.nextLine();
                System.out.println("Last Name: ");
                System.out.println(searchByLastName(s.nextLine()));
            }
            else if (input == 8){
                s.nextLine();
                System.out.println("Phone Number: ");
                System.out.println(searchByPhoneNumber(s.nextLine()));
            }
            else if (input != 0){
                System.out.println("Menu:\n1. Add Contact\n2. List All Contacts By First Name\n3. List All Contacts By Last Name\n4. List All Contacts By Phone Number\n5. List All Students\n6. Search By First Name\n7. Search By Last Name\n8. Search By Phone Number\n0. Exit");
            }
        }
    }

    public static void main(String[] args){
        ContactList list = new ContactList();
        list.run();
    }
}