package ue_3.s2210238039;
import kapitel_3.vl.IKey;
// @author: Stefan Miskovic s2210238039
// Aufgabe 4:
public class TelephoneBookEntryKey {
    public static class FirstAndLastName implements IKey {
        String firstname;
        String lastname;
        public FirstAndLastName(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }
        public boolean matches(Object data) {
            return firstname.equals(((TelephoneBookEntry) data).getFirstname()) && lastname.equals(((TelephoneBookEntry) data).getLastname()) ;
        }
    }
}
