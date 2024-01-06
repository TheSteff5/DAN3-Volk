package ue_4.s2210238039;

import kapitel_3.Queue;
import kapitel_3.tests.Student;
import kapitel_3.vl.BTree;
import kapitel_3.vl.IKey;
import kapitel_3.vl.ReferenceKey;
import ue_3.s2210238039.TelephoneBookEntry;

public class MyBTree extends BTree {

    public MyBTree(Node tree) {
        super();
        root = tree;

    }

    // Aufgabe 1:
    protected void breadthFirstAppend(Node newNode) {
        Queue queue = new Queue();

        if (root != null) {
            queue.enqueue(root);
        }

        while (!queue.empty()) {
            Node current = (Node) queue.dequeue();
            if (current.left != null) {
                queue.enqueue(current.left);
            } else {
                current.left = newNode;
                return;
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            } else {
                current.right = newNode;
                return;
            }
        }
    }

    public void insert(Object data) {
        breadthFirstAppend(new Node(null, data, null));
    }

    // Aufgabe 2:
    public void remove(Object data) {
        remove(breadthFirstSearch(root, new DataKey(data)));
    }

    protected void remove(Node node) {
        if (node != null) {
            Node toRemove = switchNodes(node);

            if (toRemove.parent.left != null && toRemove.parent.left.data.equals(toRemove.data)) {
                toRemove.parent.left = null;
            }

            if (toRemove.parent.right != null && toRemove.parent.right.data.equals(toRemove.data)) {
                toRemove.parent.right = null;
            }
        }
    }

    protected Node switchNodes(Node toRemove) {
        Node replacementNode = null;
        if (toRemove != null) {
            replacementNode = searchSmallest(toRemove.right);
            if (replacementNode == null) {
                replacementNode = searchLargest(toRemove.left);
            }
            exchangeDatasets(toRemove, replacementNode);
        }

        return (replacementNode != null) ? replacementNode : toRemove;
    }

    // Aufgabe 4.3:
    // Antwort: Der Code wurde um Zeile 103 erweitert.
    // Ohne der Zeile, hätte man noch immer eine Referenz zum Parent Node, falls der root node gelöscht werden sollte.
    // Was zu Memory Leaks oder unerwarteten Verhalten führen kann.
    // Die Referenz zum Objekt bleibt bestehen und wird nicht vom garbage collector gefunden.
    protected void removeLeaf(Node toRemove) { // Remove a leaf or a half-leave from the
        if (toRemove.isLeftChild()) {          // tree. This algorithm has an error -
            toRemove.parent.left = null;       // deliberately. The students have to search
            if (toRemove.right != null) {      // for it and to discuss it.
                toRemove.parent.left = toRemove.right;
                toRemove.right.parent = toRemove.parent;
            } else if (toRemove.left != null) {
                toRemove.parent.left = toRemove.left;
                toRemove.left.parent = toRemove.parent;
            }
        } else if (toRemove.isRightChild()) {
            toRemove.parent.right = null;
            if (toRemove.left != null) {
                toRemove.parent.right = toRemove.left;
                toRemove.left.parent = toRemove.parent;
            } else if (toRemove.right != null) {
                toRemove.parent.right = toRemove.right;
                toRemove.right.parent = toRemove.parent;
            }
        } else {
            root = toRemove.left != null ? toRemove.left : toRemove.right;
            root.parent = null;
        }
    }


    protected Node searchSmallest(Node node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    protected Node searchLargest(Node node) {
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }
        return node;
    }


}

class DataKey implements IKey {
    Object data;

    public DataKey(Object data) {
        this.data = data;
    }

    public boolean matches(Object data) {
        return this.data.equals(data);
    }
}



