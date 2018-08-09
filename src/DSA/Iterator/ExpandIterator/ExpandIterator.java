package DSA.Iterator.ExpandIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
 *  给个array,比如[2,3,4,10...] 每两个两个看， 代表3出现两次，10出现4次。要求实现NEXT()和HASNEXT()。
 *  用个pointer和counter记录一下就好了啊，注意corner case。follow up: 给的不是array,是个iterator.
 *  BF: precompute, space too large, trival
 *  Use pointer and count
 *  case -1 0 
 *  O(N) Space
 */
public class ExpandIterator implements Iterator<Integer> {
    int index;
    int counter;
    int[] nums;

    public ExpandIterator(int[] nums) {
        index = 0;
        counter = nums[0];
        this.nums = nums;
    }
    @Override
    public boolean hasNext() {
        if (index >= nums.length) {
            return false;
        }
        return true;
    }
    @Override
    public Integer next() {
        if (!hasNext()) {
            return -1;
        }

        int res = nums[index + 1];
        counter--;
        if (counter == 0) {
            index += 2;
            if (index < nums.length) counter = nums[index];
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] array = {1,3,3,5,2,7};
        int[] array2 = {0, 3,5,1,2,9};
        int[] array3 = {1,1};
        ExpandIterator iter = new ExpandIterator(array3);
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        List<Integer> list = Arrays.asList(1,3,3,5,2,7);
        ExpandIteratorNice iter2 = new ExpandIteratorNice(list.iterator());
        while(iter2.hasNext()) {
            System.out.println(iter2.next());
        }
        
    }
}

// if input is an iterator
class ExpandIteratorNice {
    Iterator<Integer> iter;
    int count;
    int cur;
    public ExpandIteratorNice(Iterator<Integer> iterator) {
        iter = iterator;
        count = iter.next();
        cur = iter.next();
    }
    public boolean hasNext() {
        return count > 0;
    }
    
    public int next() {
        int res = cur;
        count--;
        if (count == 0) {
            if (iter.hasNext()) count = iter.next();
            if (iter.hasNext()) cur = iter.next();
        }
        return res;
    }
    
}


