package DSA.Iterator.PeekingIterator;
import java.util.ArrayList;
/*
 * iven an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Example:

Assume that the iterator is initialized to the beginning of the list: [1,2,3].

Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element.
Calling hasNext() after that should return false.
Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
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

class StringIterator {
    ArrayList<Character> list;
    Iterator<Character> iter;
    public StringIterator(String compressedString) {
        list = new ArrayList<>();
        int i = 0;
        while (i < compressedString.length()) {
            char c = compressedString.charAt(i);
            int j = i + 1;
            int n = 0;
            while (Character.isDigit(compressedString.charAt(j))){
                n = 10 * n + (compressedString.charAt(j) - '0');
            }

            while (n > 0) {
                list.add(c);
                n--;
            }
            i = j - 1;
        }
        iter = list.iterator();
    }

    public char next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }
}
