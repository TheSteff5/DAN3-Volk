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
                current.left.parent = current;
                return;
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            } else {
                current.right = newNode;
                current.right.parent = current;
                return;
            }
        }
    }

    public void insert(Object data) {
        breadthFirstAppend(new Node(null, data, null));
    }

    // Aufgabe 2:
    // Beschreibung:
    // Zuerst muss im Baum nach dem Datensatz mittels DataKey gesucht werden
    // Der Knoten wird dann in die protected remove methode übergeben.
    public void remove(Object data) {
        remove(breadthFirstSearch(root, new DataKey(data)));
    }

    // In der remove Methode wird dann zuerst der toRemove Knoten gesetzt.
    // da wurde die switchNodes Methode aus der Vorlesung verwendet.
    // Nachdem die Nodes getauscht wurden, muss über die Parentreferenz der Node gelöscht werden
    // Anders war es mir nicht möglich. Aus diesem Grund ist is bei diesem Baum auch wichtig eine Parentreferenz zu haben!
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

    // Man muss isch entscheiden ob man den kleinsten Datensatz des rechten Sub-Baumes
    // oder den größten Datensatz des linken Sub-Baumes löschen möchte
    // in der Methode wird im Baum durchiteriert und danach ein replacementNode gesetzt
    // mit exchangeDatasets werden !VORISCHT nur daten und nicht referenzen getauscht.
    // falls ein replacement stattgefunden hat wird auch der replacementNode zurückgegeben
    // sonst wird übergebene node wieder zurückgegeben, da es sich um ein Baumblatt handelt.
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
    // Prosa:
    /*
    removeLeaf wird aufgerugen und erhlt einen Knoten als Parameter. Zuerst wird überprüft, ob der
    Knoten ein Blatt ist, wenn ja, wir der Knoten aus dem Baum entfernt. Falls es sich um ein Halbblatt handelt,
    ein Knoten mit nur einem Child, wird der Knoten durch seinen einzigen Nachfolger ersetzt.
    Der Algorithmus stellt sicher, dass die Verknüpfungen im Baum richtig aktualisiert werden um die Eigenschaften eines binären Baums zu erhalten.
     */
    /*
    Stilisierte Prosa:
    1. removeLeaf erhält Knoten als Eingabe
    2. Es wird überprüft, ob der Knoten ein Blatt ist
        1. Wenn ja, Knoten wird aus Baum entfernt
        2. Falls es sich um ein Halbblatt handelt
            1. Es wird ein Nachfolger des zu entfernenden Knotens ermittelt
            2. Die Verbindung des parent Knotens wird zu dem des entfernenden Knotens auf den Nachfolger aktualisiert
     */

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

    public Node getRoot() {
        return root;
    }
}



