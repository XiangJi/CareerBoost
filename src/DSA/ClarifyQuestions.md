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