package kapitel_3;

import kapitel_3.vl.IRIterator;
import kapitel_3.vl.DList;

public class Queue {
    protected DList dList = new DList();

    public void enqueue(Object data) {
        dList.prepend(data);
    }

    public Object peek() {

        IRIterator iterator = dList.rIterator();
        Object returnData = null;

        if (iterator.hasPrevious()) {
            returnData = iterator.previous();
        }

        return returnData;
    }

    public Object dequeue() {
        Object returnData = peek();

        if (returnData != null) {
            dList.forwardRemove(returnData);
        }

        return returnData;
    }

    public boolean empty() {
        return !dList.rIterator().hasPrevious();
    }
}