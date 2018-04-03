package DSA.Iterator.ZigzagIterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {
    //time : O(n), space : O(2)
    private Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) { // use !v1.isEmpty() not null
            queue.offer(v1.iterator());
        }
        if (!v2.isEmpty()) {
            queue.offer(v2.iterator()); // list interface has all have iterator
        }
    }

    public int next() {
        Iterator now = queue.poll();
        Integer result = (Integer) now.next();

        // offer only when there are items left
        if(now.hasNext()) {
            queue.offer(now);
        }
        return result;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * private Iterator<Integer> i, j, temp;


    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
 *
 */

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

