package ue_3.s2210238039;

import kapitel_3.vl.IKey;
import kapitel_3.vl.SList;

// @author: Stefan Miskovic s2210238039
public class MySList extends SList {
    public MySList(){
        super();
    }

    // Aufgabe 1:
    public void append(Object data){
        Node newNode = new Node(data, null);
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next =  newNode;
    }

    // Aufgabe 2:
    public boolean insert(Object prev, Object data){
        Node newNode = new Node(data, null);
        Node current = head;

        while (current != null && !current.data.equals(prev)){  //falls kein prev gefunden wurde,
            current = current.next;                             // wird die Liste bis zum ende iteriert und current besitzt den Wert null
        }

        if(current == null){
            return false;
        }

        newNode.next = current.next;
        current.next = newNode;

        return true;
    }

    // Aufgabe 3:
    public SList searchAll(IKey key){
        Node current = head;
        SList results = new SList();
        while(current != null) {
            if(key.matches(current.data)){
                results.prepend(current.data);
            }
            current = current.next;
        }

        return results;
    }

}
