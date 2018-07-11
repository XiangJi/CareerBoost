# Array and List

List a;

a.size();   not length()!

if (//condition && make sure index not out of bound)

Usage:

new ArrayList<String>(Arrays.asList("0", "1", "8"));



Collection——List and Set, 用iterator向后便利，set里unique

List —— ArrayList LinkedList

Set——TreeSet, HashSet, LinkedHashSet

Map ——TreeMap, HashMap, LinkedHashMap



TreeMap / TreeSet 操作都是O(logN)

Set都是用map实现的

TreeMap内部使用红黑树实现，自动以key排序

当需要查找某些元素以及顺序输出元素的时候它能够带来比较理想的结果。

排好序的hash表



Find missing number in a positive integer array, 用tricky的桶排序