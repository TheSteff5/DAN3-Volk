package ue_3.s2210238039;
// @author: Stefan Miskovic s2210238039
// Aufgabe 4:
public class TelephoneBookEntry {
    private String firstname;
    private String lastname;
    private String[] phonenumber;
    private String street;

    public TelephoneBookEntry(String firstname, String lastname, String[] phonenumber, String street){
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.street = street;
    }

    public String toString() {
        return "Firstname: " + this.firstname + "\nLastname: " + lastname + "\nPhonenumber: " + phonenumber + "\nStreet: " + this.street;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String[] getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String[] phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
