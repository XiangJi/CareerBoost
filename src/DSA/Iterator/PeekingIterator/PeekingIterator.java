package DSA.Iterator.PeekingIterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer head = null;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            head = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return head;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = head;
        head = iter.hasNext() ? iter.next() : null; // move cursor
        return result;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }
}    