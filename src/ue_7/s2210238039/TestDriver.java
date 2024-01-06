package ue_7.s2210238039;
import kapitel_3.vl.DList;
import kapitel_3.vl.IFIterator;

/**
 * @author: Stefan Miskovic s2210238039
 */
public class TestDriver {
    public static void main(String[] args) {
        // Aufgabe 1:
       DList dList = new DList();
       dList.prepend(1);
       dList.prepend(3);
       dList.prepend(7);
       dList.prepend(6);
       dList.prepend(2);

        IFIterator myDListIterator = dList.fIterator();

        System.out.println("######### Exercise 1 #########");
        System.out.println("BUBBLE SORT");
        System.out.println("unsorted Values:");
        while(myDListIterator.hasNext()){
            System.out.println(myDListIterator.next());
        }

       SortUtil.bubbleSort(dList.head);

        myDListIterator = dList.fIterator();

        System.out.println("sorted Values:");
        while(myDListIterator.hasNext()){
            System.out.println(myDListIterator.next());
        }

        // Aufgabe 2:
        DList dList2 = new DList();
        dList2.prepend(7);
        dList2.prepend(4);
        dList2.prepend(7);
        dList2.prepend(3);
        dList2.prepend(1);

        IFIterator myDListIterator2 = dList2.fIterator();

        System.out.println("######### Exercise 2 #########");
        System.out.println("INSERTION SORT");
        System.out.println("unsorted Values:");
        while(myDListIterator2.hasNext()){
            System.out.println(myDListIterator2.next());
        }

        SortUtil.insertionSort(dList2.head);

        myDListIterator2 = dList2.fIterator();

        System.out.println("sorted Values:");
        while(myDListIterator2.hasNext()){
            System.out.println(myDListIterator2.next());
        }

        // Aufgabe 3:
        DList dList3 = new DList();
        dList3.prepend(1);
        dList3.prepend(4);
        dList3.prepend(7);
        dList3.prepend(3);
        dList3.prepend(9);
        dList3.prepend(8);
        dList3.prepend(1);

        IFIterator myDListIterator3 = dList3.fIterator();

        System.out.println("######### Exercise 3 #########");
        System.out.println("SELECTION SORT");
        System.out.println("unsorted Values:");
        while(myDListIterator3.hasNext()){
            System.out.println(myDListIterator3.next());
        }

        SortUtil.selectionSort(dList3.head);

        myDListIterator3 = dList3.fIterator();

        System.out.println("sorted Values:");
        while(myDListIterator3.hasNext()){
            System.out.println(myDListIterator3.next());
        }
    }
}
