package ue_4.s2210238039;

import kapitel_3.tests.Student;
import kapitel_3.vl.BTree;
import kapitel_3.vl.IFIterator;
import org.w3c.dom.Node;

// @author: Stefan Miskovic s2210238039
public class TestDriver {
    public static void main(String[] args) {
        MyBTree myTree = new MyBTree(new BTree.Node(new BTree.Node(null, new Student("Stefan", "Miskvoic", "2"), null), new Student("Nico", "Wimmer", "1"), new BTree.Node(null, new Student("Denis", "Bauer", "3"), null)));

        // Aufgabe 4.1
        myTree.insert(new Student("Sandro", "Tadic", "4"));
        myTree.insert(new Student("Irgendwos", "Test", "5"));
        myTree.insert(new Student("Irgendwos6", "Test6", "6"));
        myTree.insert(new Student("Irgendwos7", "Test7", "7"));

        IFIterator treeIterator = myTree.iterator();
        while (treeIterator.hasNext()) {
            System.out.println(treeIterator.next().toString());

        }

        // Aufgabe 4.2
        System.out.println("Initial Tree: ");
        BTree.Node node1 = new BTree.Node(null, 1, null);
        BTree.Node node2 = new BTree.Node(null, 2, null);
        BTree.Node node3 = new BTree.Node(null, 3, null);
        BTree.Node node6 = new BTree.Node(node2, 6, node1);
        BTree.Node root = new BTree.Node(node3, 7, node6);
        node1.parent = node6;
        node2.parent = node6;
        node6.parent = root;
        node3.parent = root;
        MyBTree myTree2 = new MyBTree(root);

        IFIterator myTree2Iterator = myTree2.iterator();
        while (myTree2Iterator.hasNext()) {
            System.out.println(myTree2Iterator.next().toString());
        }

        System.out.println("Removed Data value 6: ");
        myTree2.remove(6);
        myTree2Iterator = myTree2.iterator();
        while (myTree2Iterator.hasNext()) {
            System.out.println(myTree2Iterator.next().toString());
        }

        System.out.println("Initial Tree: ");
        node1 = new BTree.Node(null, 1, null);
        node2 = new BTree.Node(null, 2, null);
        node3 = new BTree.Node(null, 3, null);
        node6 = new BTree.Node(node2, 6, node1);
        root = new BTree.Node(node3, 7, node6);
        node1.parent = node6;
        node2.parent = node6;
        node6.parent = root;
        node3.parent = root;

        MyBTree myTree3 = new MyBTree(root);
        IFIterator myTree3Iterator = myTree3.iterator();
        while (myTree3Iterator.hasNext()) {
            System.out.println(myTree3Iterator.next().toString());
        }

        System.out.println("Removed Data value 7: ");
        myTree3.remove(7);
        myTree3Iterator = myTree3.iterator();
        while (myTree3Iterator.hasNext()) {
            System.out.println(myTree3Iterator.next().toString());
        }

        System.out.println("Initial Tree: ");
        node1 = new BTree.Node(null, 1, null);
        node2 = new BTree.Node(null, 2, null);
        node3 = new BTree.Node(null, 3, null);
        node6 = new BTree.Node(node2, 6, node1);
        root = new BTree.Node(node3, 7, node6);
        node1.parent = node6;
        node2.parent = node6;
        node6.parent = root;
        node3.parent = root;

        MyBTree myTree4 = new MyBTree(root);
        IFIterator myTree4Iterator = myTree4.iterator();
        while (myTree4Iterator.hasNext()) {
            System.out.println(myTree4Iterator.next().toString());
        }

        System.out.println("Removed Data value 3: ");
        myTree4.remove(3);
        myTree4Iterator = myTree4.iterator();
        while (myTree4Iterator.hasNext()) {
            System.out.println(myTree4Iterator.next().toString());
        }
    }
}
