package DSA.Iterator.DesignCompressedStringIterator;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.

The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.

next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
hasNext() - Judge whether there is any letter needs to be uncompressed.

Note:
Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.

Example:

StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

iterator.next(); // return 'L'
iterator.next(); // return 'e'
iterator.next(); // return 'e'
iterator.next(); // return 't'
iterator.next(); // return 'C'
iterator.next(); // return 'o'
iterator.next(); // return 'd'
iterator.hasNext(); // return true
iterator.next(); // return 'e'
iterator.hasNext(); // return false
iterator.next(); // return ' '

Since no precomputation is done, constant space is required in this case.

The time required to perform next() operation is O(1)O(1).

The time required for hasNext() operation is O(1)O(1).

Since no precomputations are done, and hasNext() requires only O(1)O(1) time, this solution is advantageous if hasNext() operation is performed most of the times.

 */
public class StringIterator {
    String res;
    int ptr = 0, num = 0;
    char ch = ' ';
    public StringIterator(String s) {
        res = s;
    }
    public char next() {
        if (!hasNext())
            return ' ';
        if (num == 0) {
            ch = res.charAt(ptr++);
            while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                num = num * 10 + res.charAt(ptr++) - '0';
            }
        }
        num--;
        return ch;
    }
    public boolean hasNext() {
        return ptr != res.length() || num != 0;
    }
}

class StringIteratorBF {
    ArrayList<Character> list;
    Iterator<Character> iter;
    public StringIteratorBF(String compressedString) {
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