# Height-Balanced BST

## Concepts

A height-balanced BST is a special form of BST which aims at improving the performance. The details of implementations are outside the scope of this article series and are not required in most interviews. But it is useful to understand the general idea of a height-balanced BST and how height-balanced BSTs can help you in your algorithm designs.

The height-balanced BST is widely used in practice since it can provide search, insertion and deletion operations all in `O(logN)` time complexity.

Typically, the height-balanced BST will be used here to improve the performance from `O(N)` to `O(logN)`.

Java implemented as AVL tree





TreeSet or TreeMap

### 应用场景

几乎只出现在sweep line扫描线算法的时候，并不是很常见 所以一般不往这上面想

这种题的输入一般是一堆event, interval merge 问题或者这种天际线， 来求同时有多少在线上

 把输入放进去 就可以logN check同时有多少



## Code temple



```java
TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); // 注意这个反向BST的写法


TreeMap<Integer, Integer> calendar; // 具有map的所有方法

    public MyCalendarII() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floor = calendar.floorKey(start); // 注意语法
        Integer ceiling = calendar.ceilingKey(start);
        if (floor != null && calendar.get(floor) > start) {
            return false;
        }
        if (ceiling != null && ceiling < end) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }

TreeMap<Integer, Integer> delta; //这边放的就不是start end了 放的是 <start, end> count

    public MyCalendarTwoII() {
        delta = new TreeMap();
    }

public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1); // 注意end是离开 所以-1

        int active = 0;
        for (int d: delta.values()) { // 变量values
            active += d;
            if (active >= 3) {
                // 拿走一个
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0) // corner 如果start没有了 去除勿忘
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }

// my caldenar 3 就是airplane 就同时有多少在
```

