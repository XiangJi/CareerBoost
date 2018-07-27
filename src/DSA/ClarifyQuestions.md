# Clarify questions

1. 问清楚这个问题

   Ask for basic examples, would be your test cases

   int[] 是否有可能为空 是否是正数 是否sorted 是否有duplicate

   string ，char的取值范围是多少 大写小写 是否为空？

   如果没有结果？结果是不是唯一的？

   

2. 抽象这个问题变成算法题目

3. 自己定义input output然后confirm

4. 给一个大致的算法 说清楚

5. corner case

6. 写代码





内存放不下有两种解决方式：第一种如系统课上讲的分布式存储，如果每台机器100GB内存需要1000台机器；第二种如陈老师所说，直接存在数据库里。具体用哪一种呢，要看具体的需求，如对于读取速度要求高不高，读取和写入操作的频度等等。



New Grad Level: 用HashMap，每行都放进HashMap。就能找出不重复的行。缺点是内存放不下。

Entry Level: 先把文件Split成若干个小文件。Split的方法是，对每一行的字符串算一个hashcode然后对n取%来选择放到哪个文件里。n取决于内存大小和文件大小之间的比例。缺点是可能存在某个子文件特别大。因为%n之后未必均匀分布。

Senior Level: 采用类似外排序的思路，先顺序遍历文件，把每一行放到HashMap里，如果发现内存快满了，就把HashMap导出到Disk上，形成一个文件，然后继续重复上述操作。这样得到的文件的个数是有限，接着再通过Entry Level的方法，按照hashcode % n的方法Split这若干个文件，把 %n 相同的放在一个文件内，每个文件单独进行去重，然后再归并到一起。

另外还有一些可行的方法是，不用HashMap用BloomFilter，你可以认为BloomFilter是一种省内存的HashMap，但是可能会造成False Positive。这种方法面试官即便认可但是也还会让你继续设计上面提到的方法，因为这种方法毕竟是有缺陷的。但是实际操作的时候，如果内存和文件大小差距不是特别大的话，BF是一个很好的解决方案。

以上答案基于单机的情况，如果是多机的话，直接Map Reduce好了，没有太多可以讨论的。





Recursive time complexity

Cheatsheet**

| Equation                    | Time     | Space       | Examples               |
| --------------------------- | -------- | ----------- | ---------------------- |
| T(n) = 2*T(n/2) + O(n)      | O(nlogn) | O(logn)     | quick_sort             |
| T(n) = 2*T(n/2) + O(n)      | O(nlogn) | O(n + logn) | merge_sort             |
| T(n) = T(n/2) + O(1)        | O(logn)  | O(logn)     | Binary search          |
| T(n) = 2*T(n/2) + O(1)      | O(n)     | O(logn)     | Binary tree traversal  |
| T(n) = T(n-1) + O(1)        | O(n)     | O(n)        | Binary tree traversal  |
| T(n) = T(n-1) + O(n)        | O(n^2)   | O(n)        | quick_sort(worst case) |
| T(n) = n * T(n-1)           | O(n!)    | O(n)        | permutation            |
| T(n) = T(n-1)+T(n-2)+…+T(1) | O(2^n)   | O(n)        | combination            |