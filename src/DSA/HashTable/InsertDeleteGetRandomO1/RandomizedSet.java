package DSA.HashTable.InsertDeleteGetRandomO1;

/*
 * Design a data structure that supports all following operations in average O(1) time.
G tag好题 要写一遍

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    int n = 0;
    Map<Integer, Integer> pos = new HashMap<>();
    List<Integer> array = new ArrayList<>();
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int server_id) {
        if (!pos.containsKey(server_id)) {
            array.add(server_id);
            pos.put(server_id, n);
            n++;
            return true;
        }
        return false;
    }

    //数组和哈希结合，map里面存数和下标， 因为下标位置不能变，所以swap最后一个和被删除的 然后删最后一个
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int server_id) {
        if (pos.containsKey(server_id)) {
            int lastItem = array.get(n - 1);
            int removeIdx = pos.get(server_id);

            pos.put(lastItem, removeIdx);
            array.set(removeIdx, lastItem);

            pos.remove(server_id);
            array.remove(n - 1);
            n--;
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(rand.nextInt(n));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */