package ue_5.s2210238039;
import kapitel_3.vl.BTree;
import ue_4.s2210238039.MyBTree;

public class ArrayUtil{

    // Aufgabe 5.3
    public static Object[] convertTreeToArray(MyBTree tree) {
        Object[] array = new Object[((int)Math.pow(2, tree.height())) - 1];
        depthFirstInOrder(tree.getRoot(), array, 0);
        return array;
    }

    protected static void depthFirstInOrder(BTree.Node current, Object[] array, int index) {
        if (current != null) {
            array[index] = current.data;
            depthFirstInOrder(current.left, array, 2*index+1);
            depthFirstInOrder(current.right, array, 2*index+2);
        }
    }
}
