package ue_3.s2210238039;
import kapitel_3.tests.Student;
import kapitel_3.tests.StudentKeys;
import kapitel_3.vl.IFIterator;

// @author: Stefan Miskovic s2210238039
public class TestDriver {
    public static void main(String[] args) {
        // Aufgabe 1:
        MySList sList = new MySList();
        sList.prepend(new Student("Data1", "irgendwos", "MTD0100003"));
        Student s2 = new Student("Data2", "Christian", "MTD0100002");
        Student s3 = new Student("Data3", "Christian", "MTD0100001");
        sList.append(s2);
        sList.append(s3);
        IFIterator mySListIterator = sList.iterator();

        System.out.println("######### Exercise 1 #########");
        while(mySListIterator.hasNext()){
            System.out.println(mySListIterator.next());
        }


        // Aufgabe 2:
        sList.insert(s2, new Student("Data4", "4", "MTD0100001"));


        System.out.println("\n######### Exercise 2 #########");
        mySListIterator = sList.iterator();
        while(mySListIterator.hasNext()){
            System.out.println(mySListIterator.next());
        }


        // Aufgabe 3:
        System.out.println("\n######### Exercise 3 #########");
        mySListIterator =  sList.searchAll(new StudentKeys.MatrNrKey("MTD0100001")).iterator();
        while(mySListIterator.hasNext()){
            System.out.println(mySListIterator.next());
        }

        // Aufgabe 4:
        MySList telephoneBook = new MySList();
        IFIterator telephoneBookIterator;
        telephoneBook.prepend(new TelephoneBookEntry("Stefan", "Miskovic", new String[] {"06607445511","066910203044"}, "Dametzstraße 16"));
        telephoneBook.prepend(new TelephoneBookEntry("Nico", "Wimmer",  new String[] {"06609103211","066910203077"}, "Europaplatz 22"));
        telephoneBook.prepend(new TelephoneBookEntry("Marcel", "Wartecker",  new String[] {"0660456271","0660456233"}, "Glemmtalerstraße 1"));
        telephoneBook.prepend(new TelephoneBookEntry("Marcel", "Ivkic", new String[] {"06997114423","06997114777"}, "Lofererstraße 34"));
        telephoneBook.prepend(new TelephoneBookEntry("Stefan", "Miskovic", new String[] {"091139423"}, "Berglandstraße 1"));

        System.out.println("######### Exercise 4 #########");
        System.out.println("\nSINGLE SEARCH: ");
        TelephoneBookEntry searchValue = (TelephoneBookEntry) telephoneBook.search(new TelephoneBookEntryKey.FirstAndLastName("Nico", "Wimmer"));
        System.out.println(searchValue.getFirstname());
        System.out.println(searchValue.getLastname());
        System.out.println(searchValue.getStreet());
        for (String nr: searchValue.getPhonenumber()) {
            System.out.println(nr);
        }

        telephoneBookIterator = telephoneBook.searchAll(new TelephoneBookEntryKey.FirstAndLastName("Stefan", "Miskovic")).iterator();

        System.out.println("\nSEARCH ALL: ");
        while(telephoneBookIterator.hasNext()){
            TelephoneBookEntry nextEntry = (TelephoneBookEntry) telephoneBookIterator.next();
            System.out.println(nextEntry.getFirstname());
            System.out.println(nextEntry.getLastname());
            System.out.println(nextEntry.getStreet());
            for (String nr: nextEntry.getPhonenumber()) {
                System.out.println(nr);
            }
        }
    }
}
