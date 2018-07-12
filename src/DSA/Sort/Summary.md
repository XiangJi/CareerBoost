# Sort

常见的排序算法根据是否需要比较可以分为如下几类：

- Comparison Sorting

1. Bubble Sort
2. Selection Sort
3. Insertion Sort
4. Shell Sort
5. Merge Sort
6. Quck Sort
7. Heap Sort

- Bucket Sort
- Counting Sort
- Radix Sort



不要老是先想数据结构 很多时候greedy法的时候

需要按规则直接讲数组sort

要会写comparator和lamda expression

```java
Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String X = a + b;
                String Y = b + a;
                return Y.compareTo(X) > 0 ? 1: - 1;
            }
        });
```

