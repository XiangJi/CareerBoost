# Trie

## Concepts

trie，又称前缀树或字典树，是一种有序树，用于保存关联数组，其中的键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的位置决定。一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串。一般情况下，不是所有的节点都有对应的值，只有叶子节点和部分内部节点所对应的键才有相关的值。
trie中的键通常是字符串，但也可以是其它的结构。trie的算法可以很容易地修改为处理其它结构的有序序列，比如一串数字或者形状的排列。比如，bitwise trie中的键是一串位元，可以用于表示整数或者内存地址。

- 根节点不包含字符，除根节点外每一个节点都只包含一个字符。


- 每个节点的所有子节点包含的字符都不相同。

典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
Trie的核心思想是空间换时间。利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

Trie树也有它的缺点,Trie树的内存消耗非常大.

The complexity to contruct a trie structure is O(n*m).  

insert or search are O(n) n is the length of the string, considered as constant

### 应用场景

多次查找字符串prefix的情况 使用这个优化时间

wordSqure 用trie树存大大优化了搜索时间 直接去trie里看对不对

wordSearchII 此题类似 只不过在2d图上搜索

## Code Template

```java
class TrieNode {
       List<String> startWith;
       TrieNode[] children;

       TrieNode() {
           startWith = new ArrayList<>();
           children = new TrieNode[26];
       }
   }

class Trie {
       TrieNode root;

       Trie(String[] words) {
           root = new TrieNode();
           for (String w : words) {
               TrieNode cur = root;
               for (char ch : w.toCharArray()) {
                   int idx = ch - 'a';
                   if (cur.children[idx] == null)
                       cur.children[idx] = new TrieNode();
                   cur.children[idx].startWith.add(w);
                   cur = cur.children[idx];
               }
           }
       }

       List<String> findByPrefix(String prefix) {
           List<String> ans = new ArrayList<>();
           TrieNode cur = root;
           for (char ch : prefix.toCharArray()) {
               int idx = ch - 'a';
               if (cur.children[idx] == null)
                   return ans;

               cur = cur.children[idx];
           }
           ans.addAll(cur.startWith);
           return ans;
       }
   }

   public List<List<String>> wordSquares(String[] words) {
       List<List<String>> ans = new ArrayList<>();
       if (words == null || words.length == 0)
           return ans;
       int len = words[0].length();
       Trie trie = new Trie(words);
       List<String> ansBuilder = new ArrayList<>();
       for (String w : words) {
           ansBuilder.add(w);
           search(len, trie, ans, ansBuilder);
           ansBuilder.remove(ansBuilder.size() - 1);
       }

       return ans;
   }

   private void search(int len, Trie tr, List<List<String>> ans,
           List<String> ansBuilder) {
       if (ansBuilder.size() == len) {
           ans.add(new ArrayList<>(ansBuilder));
           return;
       }

       int idx = ansBuilder.size();
       StringBuilder prefixBuilder = new StringBuilder();
       for (String s : ansBuilder)
           prefixBuilder.append(s.charAt(idx));
       List<String> startWith = tr.findByPrefix(prefixBuilder.toString());
       for (String sw : startWith) {
           ansBuilder.add(sw);
           search(len, tr, ans, ansBuilder);
           ansBuilder.remove(ansBuilder.size() - 1);
       }
   }
}
```

