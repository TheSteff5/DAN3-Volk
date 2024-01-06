package ue_4.s2210238039;

import kapitel_3.Queue;
import kapitel_3.tests.Student;
import kapitel_3.vl.BTree;
import kapitel_3.vl.IKey;
import kapitel_3.vl.ReferenceKey;
import ue_3.s2210238039.TelephoneBookEntry;

public class MyBTree  extends BTree {

    public MyBTree(Node tree) {
        super();
        root = tree;
    }

    // Aufgabe 1:
    protected void breadthFirstAppend(Node newNode){
        Queue queue = new Queue();

        if (root != null){
            queue.enqueue(root);
        }

        while(!queue.empty()){
            Node current = (Node) queue.dequeue();
            if(current.left != null){
                queue.enqueue(current.left);
            }else {
                current.left = newNode;
                return;
            }

            if(current.right != null){
                queue.enqueue(current.right);
            }else {
                current.right = newNode;
                return;
            }
        }
    }

    public void insert(Object data){
        breadthFirstAppend(new Node(null,data, null));
    }

    // Aufgabe 2:
    public void remove(Object data){
        remove(breadthFirstSearch(root, new DataKey(data)));
    }

    protected void remove(Node node){
        if(node != null){
            Node toRemove = switchNodes(node);
            System.out.println(root);
            Queue queue = new Queue();
            queue.enqueue(node);
            while(!queue.empty()){
                Node current = (Node) queue.dequeue();
                    if(current.left!=null && current.left.data.equals(toRemove.data)){
                        queue.enqueue(current.left);
                        current.left = null;
                    }

                    if(current.right!=null && current.right.data.equals(toRemove.data)){
                        queue.enqueue(current.right);
                        current.right = null;
                    }

                    if(current != null && current.data.equals(toRemove.data)){
                        toRemove = null;
                    }
            }
        }
    }

    protected Node switchNodes(Node toRemove) {
        Node replacementNode = null;
        if(toRemove != null){
            replacementNode =  searchSmallest(toRemove.right);
            if(replacementNode == null){
                replacementNode =  searchLargest(toRemove.left);
            }
            exchangeDatasets(toRemove, replacementNode);
        }

        return (replacementNode != null) ? replacementNode : toRemove;
    }


    protected  Node searchSmallest(Node node){
        if(node != null){
            while(node.left != null){
                node = node.left;
            }
        }
        return node;
    }

    protected Node searchLargest(Node node){
        if (node != null){
            while(node.right != null){
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



