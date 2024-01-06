package ue_4.s2210238039;

import kapitel_3.tests.Student;
import kapitel_3.vl.BTree;
import kapitel_3.vl.IFIterator;
import org.w3c.dom.Node;

// @author: Stefan Miskovic s2210238039
public class TestDriver {
    public static void main(String[] args) {
        MyBTree myTree = new MyBTree(new BTree.Node(new BTree.Node(null,new Student("Stefan", "Miskvoic", "2"), null), new Student("Nico", "Wimmer", "1"), new BTree.Node(null,new Student("Denis", "Bauer", "3"), null)));

        // Aufgabe 4.1
        myTree.insert(new Student("Sandro", "Tadic", "4"));
        myTree.insert(new Student("Irgendwos", "Test", "5"));
        myTree.insert(new Student("Irgendwos6", "Test6", "6"));
        myTree.insert(new Student("Irgendwos7", "Test7", "7"));

        IFIterator treeIterator = myTree.iterator();
        while(treeIterator.hasNext()){
            System.out.println(treeIterator.next().toString());

        }

        // Aufgabe 4.2
        System.out.println("Initial Tree: ");
        MyBTree myTree2 = new MyBTree(new BTree.Node(new BTree.Node(null,3,null),7, new BTree.Node(new BTree.Node(null, 2, null),6, new BTree.Node(null, 1, null))));
        IFIterator myTree2Iterator = myTree2.iterator();
        while(myTree2Iterator.hasNext()){
            System.out.println(myTree2Iterator.next().toString());
        }

        System.out.println("Removed Data 6: ");
        myTree2.remove(6);
        myTree2Iterator = myTree2.iterator();
        while(myTree2Iterator.hasNext()){
            System.out.println(myTree2Iterator.next().toString());
        }

       System.out.println("Initial Tree: ");
        MyBTree myTree3 = new MyBTree(new BTree.Node(new BTree.Node(null,3,null),7, new BTree.Node(new BTree.Node(null, 2, null),6, new BTree.Node(null, 1, null))));
        IFIterator myTree3Iterator = myTree3.iterator();
        while(myTree3Iterator.hasNext()){
            System.out.println(myTree3Iterator.next().toString());
        }

        System.out.println("Removed Data 1: ");
        myTree3.remove(1);
        myTree3Iterator = myTree3.iterator();
        while(myTree3Iterator.hasNext()){
            System.out.println(myTree3Iterator.next().toString());
        }
    }
}
