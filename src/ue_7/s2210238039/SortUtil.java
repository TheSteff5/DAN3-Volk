package ue_7.s2210238039;
import kapitel_3.vl.DList;

/**
 * @author: Stefan Miskovic s2210238039
 */

public class SortUtil extends DList {
    public static void bubbleSort(Node list) {
        Node currentM = list;
        while(currentM != null && currentM.next != null){
            Node currentI = list;
            while(currentI.next != null){
                if((int)currentI.data > (int) currentI.next.data){
                    Object tmp = currentI.data;
                    currentI.data = currentI.next.data;
                    currentI.next.data = tmp;
                }
                currentI = currentI.next;
            }
            currentM = currentM.next;
        }
    }

    public static void insertionSort(Node list) {
        Node i = list;
        while(i != null && i.next != null){
            int h = (int)i.next.data;
            Node j = i;
            while (j != null && (int)j.data > h){
                j.next.data = j.data;
                j = j.prev;
            }
            j.next.data = h;
            i = i.next;
        }
    }

    public static void selectionSort(Node list) {
        Node i = list;
        while(i != null && i.next != null){
            Node min = i;
            Node j = i.next;
            while(j!=null){
                if((int)j.data < (int)min.data){
                    min = j;
                }
                j = j.next;
            }

            int tmp = (int)i.data;
            i.data = min.data;
            min.data = tmp;

            i = i.next;
        }
    }
}
