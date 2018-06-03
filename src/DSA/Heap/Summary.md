# Priority Queue/ Heap

PQ是一种树(tree), 准确的说, 是一种二叉树(binary tree), 说得再准确一点, 它是一种完全二叉树(complete binary tree): 没错, PQ是一种满足某些条件的完全二叉树.

所谓的"完全二叉树", 要满足:

除了最后一层, 所有层都排满(没有非空节点)
最后一层的所有非空节点都排在左边



Insert/delete logN

peek   O(1)

**add**
加入新元素的时候, 只要先把它放在最后面, 然后调用siftup()函数调整一下pq即可:



**poll**
堆顶元素被拿走以后, 我们可以先把最后一个元素放在顶部, 然后调用siftdown进行调整:



应用

1. heap sort

   由于每次出队的都是在剩下元素里面最大(小)的, 所以只要把数组的元素放到一个pq里, 然后依次poll出来, 得到的序列就是排序好了的.

   不管是插入还是删除操作, 每次调整的复杂度为log(n) (堆的高度), 所以算法复杂度为 O(NlgN). 实际使用的时候效率比快速排序/合并排序略差。

2. top k elements of a stream

   问题描述: 一系列数字一个一个到达, 当所有数(假设有N个)都到达以后, 求最大的K个数字.

   这是一个经典的PQ应用 ⇒ 使用一个最小堆(minPQ)即可达到这个效果: 新建一个minPQ(最小的数字在最上面, 每次当一个数字n到达时:

   if minPQ.size<K → minPQ.add(n)
   if minPQ.size==K → 比较n和minPQ.top():
   if n>minPQ.top(): minPQ.poll(); minPQ.add(n)
   else pass...

3. lc295 median of data stream
   问题描述: 一系列数字一个一个到达, 求他们的中位数(median)?
   这个的解法是使用两个PQ, 一个最大堆maxpq一个最小堆minpq, 然后maxpq里存放较小的一半数字, minpq里存放较大的一半数字: maxpq.top()<=minpq.top(). 
   并且我们要求: minpq.size <= maxpq.size <= minpq.size+1
   ⇒ 这样中位数或者是maxpq.top(), 或者是两个top的平均值了~ 

   ​

   初始时两个pq都是空的, 每次数字n到来时:
   先把n放进maxpq里

   如果maxpq.size>minpq.size+1的话: minpq.add(maxpq.poll()) 

4. meeting rooms ii

   ​

   ​

   每次从队列中取出的是具有最高优先权的元素。如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，字符串则按字典序排列（参阅 Comparable），也可以根据 Comparator 来指定，这取决于使用哪种构造方法。基于priority heap实现，非sync，多线程用priorityblockingqueue，默认小根堆min heap，使用iterator =访问不保证有序，有序访问时需要使用Arrays.sort(pq.toArray()); 增删复杂度logn,查询o1

   ​                                                                                  

   ​





Queue<Integer> qi = new PriorityQueue<Integer>();

