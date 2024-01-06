package ue_5.s2210238039;

import kapitel_3.vl.BTree;
import kapitel_3.vl.IKey;
import kapitel_3.vl.IWorker;
import ue_4.s2210238039.DataKey;
import ue_4.s2210238039.MyBTree;

public class MyHeap extends MyBTree {

    public MyHeap(Node tree) {
        super(tree);
    }

    public void insert(Object data) {
        Node node = new Node(null, data, null);
        breadthFirstAppend(node);
        upHeap(node);
    }

    public void upHeap(Node leaf) {
        if (leaf.parent != null) {
            Object parentData = leaf.parent.data;
            if ((int) leaf.data < (int) parentData) {
                leaf.parent.data = leaf.data;
                leaf.data = parentData;
                upHeap(leaf.parent);
            }
        }
    }

    public void remove(Object data) {
        Node node = heapSearch(root, new DataKey(data));
        downHeap(node);
        Node toRemove = heapSearch(root, new DataKey(data));
        if (toRemove.parent.left != null && toRemove.parent.left.data.equals(toRemove.data)) {
            toRemove.parent.left = null;
        }

        if (toRemove.parent.right != null && toRemove.parent.right.data.equals(toRemove.data)) {
            toRemove.parent.right = null;
        }
    }

    protected void downHeap(Node node) {
        if (node.left != null && (int) node.data < (int) node.left.data) {
            Object childData = node.left.data;
            node.left.data = node.data;
            node.data = childData;
            downHeap(node.left);
        } else if (node.right != null && (int) node.data < (int) node.right.data) {
            Object childData = node.right.data;
            node.right.data = node.data;
            node.data = childData;
            downHeap(node.right);
        }
    }

    public Object heapSearch(IKey key) {
        return search(key);
    }

    protected Node heapSearch(Node current, IKey key) {
        return depthFirstSearch(current, key);
    }
}







