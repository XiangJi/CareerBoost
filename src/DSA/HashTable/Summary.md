# Hash Table

Hash Table's value 会被覆盖如果key一样

key value的选择

因为要用到containsKey做判断，key一定要是尽量不能重复的选项，和本能反一反选择

<String, Integer>

HashMap

get(key)

put(key, value)

containsKey(key)

containsValue(value)

isEmpty()

size()

remove(key, <optional - value>)

HashSet
add
remove
contains
isEmpty



When using hash map to store string count, can just use array instead.

128 ACSII characters for string, next 128 are extended special characters



简单的Palindrome问题要直接想到上面的hash存储方式

3685
down vote
×


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


