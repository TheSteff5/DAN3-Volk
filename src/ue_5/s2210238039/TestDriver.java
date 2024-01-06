package ue_5.s2210238039;
import kapitel_3.vl.BTree;
import kapitel_3.vl.IFIterator;

import java.util.Arrays;

public class TestDriver {
    public static void main(String[] args) {

        // Aufgabe 5.1:
        BTree.Node node7 = new BTree.Node(null, 7, null);
        BTree.Node node5 = new BTree.Node(null, 5, null);
        BTree.Node root = new BTree.Node(node5, 3, node7);
        node7.parent = root;
        node5.parent = root;

        MyHeap myTree = new MyHeap(root);

        IFIterator myTreeIterator;

        System.out.println("Initial tree:");
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        System.out.println("####EXERCISE 5.1####");
        System.out.println("Insert 2: ");
        myTree.insert(2);
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        System.out.println("Insert 1: ");
        myTree.insert(1);
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        System.out.println("Insert 4: ");
        myTree.insert(4);
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        // Aufgabe 5.3
        System.out.println("####EXERCISE 5.3####");
        System.out.println(Arrays.toString(ArrayUtil.convertTreeToArray(myTree)));

        // Aufgabe 5.2:
        System.out.println("####EXERCISE 5.2####");
        System.out.println("Initial tree:");
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        System.out.println("Remove 1: ");
        myTree.remove(1);
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        System.out.println("Remove 3: ");
        myTree.remove(3);
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        System.out.println("Remove 5: ");
        myTree.remove(5);
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }

        System.out.println("Remove 7: ");
        myTree.remove(7);
        myTreeIterator = myTree.iterator();
        while (myTreeIterator.hasNext()) {
            System.out.println(myTreeIterator.next().toString());
        }
    }

}

