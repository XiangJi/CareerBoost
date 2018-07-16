# Hash Table

Hash Table's value 会被覆盖如果key一样

key value的选择

### 应用场景

最为万能的数据结构 被拿来做时间复杂度优化

 比如subarray substring问题 可用hatbale来保持要check的信息

Preflix sum问题进一步优化

别的数据结构直接用的概率很小

 array>intm boolean>HashMap(一家独大 存储计算过的数据)>Heap>Trie>Stack>TreeMap<BST>Queue



很多情况也可以用array来简化 如果只存一个boolean 或者count的话

常用于adjacent list用

When using hash map to store string count, can just use array instead.

128 ACSII characters for string, next 128 are extended special characters



### 哈希表的实现

hash funciton md5（key） % talbe size

hash confliction

closed hash -> array ， 新的value不离开本表

开放地执法有一个公式:Hi=(H(key)+di) MOD m i=1,2,...,k(k<=m-1)
其中，m为哈希表的表长。di 是产生冲突的时候的增量序列。如果di值可能为1,2,3,...m-1，称线性探测再散列。linear probing

open hash ->  use linked list   java use this one

链地址法的基本思想是，为每个 Hash 值建立一个单链表，当发生冲突时，将记录插入到链表中。

rehash:

当发生冲突时，使用第二个、第三个、哈希函数计算地址，直到无冲突时。缺点：计算时间增加。
比如上面第一次按照姓首字母进行哈希，如果产生冲突可以按照姓字母首字母第二位进行哈希，再冲突，第三位，直到不冲突为止



## Code template

```java
<String, Integer>

//HashMap

get(key)
getOrDefault(key, default value: 0)

put(key, value)

containsKey(key)

containsValue(value)
    

isEmpty()

size()

remove(key, <optional - value>)
    
    keySet
    values
    entrySet

//HashSet
add
remove
contains
isEmpty
```

简单的Palindrome问题要直接想到上面的hash存储方式


How to iterate HashMap:

If you're only interested in the keys, you can iterate through the keySet() of the map:


```java
Map<String, Object> map = ...;

for (String key : map.keySet()) {

// ...
}
```
If you only need the values, use values():


```java
for (Object value : map.values()) {
  // ...
  }
```

Finally, if you want both the key and value, use entrySet():

```java
for (Map.Entry<String, Object> entry : map.entrySet()) {
String key = entry.getKey();
Object value = entry.getValue();
// ...
}
```



### Practice

Bulls and Cows

GroupShiftedString

GroupAnagram

LineReflection



MaximumSizeSubarraySumEqualsk 