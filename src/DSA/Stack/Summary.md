# Stack

LIFO的数据结构

可以用来让数据逆序 

如果需要往回看数据 可以考虑用栈



单调栈其实是一个看似原理简单，但是可以变得很难的解法。线性的时间复杂度是其最大的优势，每个数字只进栈并处理一次，而解决问题的核心就在处理这块，当前数字如果破坏了单调性，就会触发处理栈顶元素的操作，而触发数字有时候是解决问题的一部分，比如在[Trapping Rain Water](http://www.cnblogs.com/grandyang/p/4402392.html)中作为右边界。有时候仅仅触发作用，比如在[Largest Rectangle in Histogram](http://www.cnblogs.com/grandyang/p/4322653.html)中是为了开始处理栈顶元素，如果仅作为触发，可能还需要在数组末尾增加了一个专门用于触发的数字。另外需要注意的是，虽然是递增或递减栈，但里面实际存的数字并不一定是递增或递减的，因为我们可以存坐标，而这些坐标带入数组中才会得到递增或递减的数。所以对于玩数组的题，如果相互之间关联很大，那么就可以考虑考虑单调栈能否解题。 



### Practice

Basic calculator I II III

evaluate reverse polish notion 因为已经转化好了 每次处理最后两个数

decode string

next greater element I, ii 

daily temperatures 都是靠stack