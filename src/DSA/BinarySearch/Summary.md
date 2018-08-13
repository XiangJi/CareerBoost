# Binary Search



在一个由从1到n元素组成的n+1长的数列中输出任意一个有重复的元素。这题需要写出四种写法。并且会考察test case。我以前一直没注意过testcase，就考官的思路是，test case要覆盖程序的所有branch。 

binary search on value, not index. 每次value range 减半，check （O(n)) if 在这个范围里面的数超过了这个范围所允许的最多不同的数（抽屉原理）， 最多logn 轮。 

就是 k = (1 + n)/2 然后one pass array 数下《=k的数字个数，如果 count > k 那么1-k中必有重复，否则k+1 - n必有重复； 继续2分搜索 



Reference from Grand Yang大神的总结

二分查找法作为一种常见的查找方法，将原本是线性时间提升到了对数时间范围，大大缩短了搜索时间，具有很大的应用场景，而在LeetCode中，要运用二分搜索法来解的题目也有很多，但是实际上二分查找法的查找目标有很多种，而且在细节写法也有一些变化。

核心思想：每次淘汰一定不对的元素 

 

#### 其实前三类都可以用九章的模板handle掉

**第一类： 需查找和目标值完全相等的数**

这是最简单的一类，也是我们最开始学二分查找法需要解决的问题，比如我们有数组[2, 4, 5, 6, 9]，target = 6，那么我们可以写出二分查找法的代码如下：

 



```java
public int search(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start + 1 < end) {
        int mid = (end - start) / 2 + start;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            end = mid;
        } else {
            start = mid;
        }
    }
    if (nums[start] == target) {
        return start;
    } else if (nums[end] == target) {
        return end;
    }
    return -1;
}
```



 

会返回3，也就是target的在数组中的位置。注意二分查找法的写法并不唯一，主要可以变动地方有四处：

第一处是right的初始化，可以写成 nums.size() 或者 nums.size() - 1

第二处是left和right的关系，可以写成 left < right 或者 left <= right

第三处是更新right的赋值，可以写成 right = mid 或者 right = mid - 1

第四处是最后返回值，可以返回left，right，或right - 1

但是这些不同的写法并不能随机的组合，像博主的那种写法，若right初始化为了nums.size()，那么就必须用left < right，而最后的right的赋值，用哪个都可以，博主偷懒就不写-1了。但是如果我们right初始化为 nums.size() - 1，那么就必须用 left <= right，并且right的赋值要写成 right = mid - 1，不然就会出错。所以博主的建议是选择一套自己喜欢的写法，并且记住，实在不行就带简单的例子来一步一步执行，确定正确的写法也行。

第一类应用实例：

[Intersection of Two Arrays](http://www.cnblogs.com/grandyang/p/5507129.html)

 

**第二类： 查找第一个不小于目标值的数，可变形为查找最后一个小于目标值的数**

这是比较常见的一类，因为我们要查找的目标值不一定会在数组中出现, 可能是找最近的insert position，也有可能是跟目标值相等的数在数组中并不唯一，而是有多个，那么这种情况下nums[mid] == target这条判断语句就没有必要存在。比如在数组[2, 4, 5, 6, 9]中查找数字3，就会返回数字4的位置；在数组[0, 1, 1, 1, 1]中查找数字1，就会返回第一个数字1的位置。我们可以使用如下代码：

 

[![复制代码](http://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```java
int find(vector<int>& nums, int target) {
    int left = 0, right = nums.size();
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < target) left = mid + 1;
        else right = mid;
    }
    return right;
}
```

 

最后我们需要返回的位置就是right指针指向的地方。在C++的STL中有专门的查找第一个不小于目标值的数的函数lower_bound，在博主的解法中也会时不时的用到这个函数。但是如果面试的时候人家不让使用内置函数，那么我们只能老老实实写上面这段二分查找的函数。

这一类可以轻松的变形为查找最后一个小于目标值的数，怎么变呢。我们已经找到了第一个不小于目标值的数，那么再往前退一位，返回right - 1，就是最后一个小于目标值的数。

第二类应用实例：

[Heaters](http://www.cnblogs.com/grandyang/p/6181626.html)， [Arranging Coins](http://www.cnblogs.com/grandyang/p/6026066.html)， [Valid Perfect Square](http://www.cnblogs.com/grandyang/p/5619296.html)，[Max Sum of Rectangle No Larger Than K](http://www.cnblogs.com/grandyang/p/5617660.html)，[Russian Doll Envelopes](http://www.cnblogs.com/grandyang/p/5568818.html)， 

 

第二类变形应用：[Valid Triangle Number](http://www.cnblogs.com/grandyang/p/7053730.html)

 

**第三类： 查找第一个大于目标值的数，可变形为查找最后一个不大于目标值的数**

这一类也比较常见，尤其是查找第一个大于目标值的数，在C++的STL也有专门的函数upper_bound，这里跟上面的那种情况的写法上很相似，只需要添加一个等号，将之前的 nums[mid] < target 变成 nums[mid] <= target，就这一个小小的变化，其实直接就改变了搜索的方向，使得在数组中有很多跟目标值相同的数字存在的情况下，返回最后一个相同的数字的下一个位置。比如在数组[2, 4, 5, 6, 9]中查找数字3，还是返回数字4的位置，这跟上面那查找方式返回的结果相同，因为数字4在此数组中既是第一个不小于目标值3的数，也是第一个大于目标值3的数，所以make sense；在数组[0, 1, 1, 1, 1]中查找数字1，就会返回坐标5，通过对比返回的坐标和数组的长度，我们就知道是否存在这样一个大于目标值的数。参见下面的代码：

 

```java
int find(vector<int>& nums, int target) {
    int left = 0, right = nums.size();
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] <= target) left = mid + 1;
        else right = mid;
    }
    return right;
}
```



 

这一类可以轻松的变形为查找最后一个不大于目标值的数，怎么变呢。我们已经找到了第一个大于目标值的数，那么再往前退一位，返回right - 1，就是最后一个不大于目标值的数。比如在数组[0, 1, 1, 1, 1]中查找数字1，就会返回最后一个数字1的位置4，这在有些情况下是需要这么做的。

第三类应用实例：

[Kth Smallest Element in a Sorted Matrix](http://www.cnblogs.com/grandyang/p/5727892.html)

第三类变形应用示例：

[Sqrt(x)](http://www.cnblogs.com/grandyang/p/4346413.html)

 

**第四类： 用子函数当作判断关系**

这是最令博主头疼的一类，而且通常情况下都很难。因为这里在二分查找法重要的比较大小的地方使用到了子函数，并不是之前三类中简单的数字大小的比较，比如[Split Array Largest Sum](http://www.cnblogs.com/grandyang/p/5933787.html)那道题中的解法一，就是根据是否能分割数组来确定下一步搜索的范围。类似的还有[Guess Number Higher or Lower](http://www.cnblogs.com/grandyang/p/5666502.html)这道题，是根据给定函数guess的返回值情况来确定搜索的范围。对于这类题目，博主也很无奈，遇到了只能自求多福了。

第四类应用实例：

[Split Array Largest Sum](http://www.cnblogs.com/grandyang/p/5933787.html)， [Guess Number Higher or Lower](http://www.cnblogs.com/grandyang/p/5666502.html)，[Find K Closest Elements](http://www.cnblogs.com/grandyang/p/7519466.html)，[Find K-th Smallest Pair Distance](http://www.cnblogs.com/grandyang/p/8627783.html)，[Kth Smallest Number in Multiplication Table](http://www.cnblogs.com/grandyang/p/8367505.html)，[Maximum Average Subarray II](http://www.cnblogs.com/grandyang/p/8021421.html)，[Minimize Max Distance to Gas Station](http://www.cnblogs.com/grandyang/p/8970057.html)，[Swim in Rising Water](http://www.cnblogs.com/grandyang/p/9017300.html)

 

综上所述，博主大致将二分搜索法的应用场景分成了主要这四类，其中第二类和第三类还有各自的扩展。根据目前博主的经验来看，第二类和第三类的应用场景最多，也是最重要的两类。第一类和第四类较少，其中第一类最简单，第四类最难，遇到这类，博主也没啥好建议，多多练习吧～



### Practice

Find k closest elements

find kth smallest pair distance 重要

minimize max distance to gas station 也是第四种

Screen fiting

search 2D matrix II

heaters 这题出的很好

median of two sorted array

Single element in and sorted array 很好用

