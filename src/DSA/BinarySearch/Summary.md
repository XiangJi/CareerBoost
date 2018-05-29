Binary Search

Implementation template:







Mistakes:



在一个由从1到n元素组成的n+1长的数列中输出任意一个有重复的元素。这题需要写出四种写法。并且会考察test case。我以前一直没注意过testcase，就考官的思路是，test case要覆盖程序的所有branch。 

binary search on value, not index. 每次value range 减半，check （O(n)) if 在这个范围里面的数超过了这个范围所允许的最多不同的数（抽屉原理）， 最多logn 轮。 

就是 k = (1 + n)/2 然后one pass array 数下《=k的数字个数，如果 count > k 那么1-k中必有重复，否则k+1 - n必有重复； 继续2分搜索 