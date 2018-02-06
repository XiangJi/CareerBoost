package DSA.Misc.iRobot;

/*
 * 给一个扫地机器人，还有三个function：
move(), which returns boolean value
turn_left(k), which make robot turns left k times.
turn_right(k), which make robot turns right k times.
Design an algorithm to make robot clean up all room. Timecomplexity, linear in term of room space.

 *已知扫地机器人有move(), turn_left(k), turn_right(k)
 *, clean()方法，机器人能面向东南西北四个方向，move是按当前方向移动一格
 *，如果不能移动返回false; turn_left(k), turn_right(k)是旋转k*90
 *度; 房间里可能有障碍物，机器人并不知道房间的布局，设计算法让扫地机器人清扫房间（走完房间每一格）。
 *
 *要自己定义各种结构，用dfs解，如何测试
 *每轮面试之间休息一下
 *
 * 这次是每做一道题进行一次总结。翻看leetcode的热门评论，把自己的解题思路和别人比自己写得好的解题思
 * 路都详细的记在笔记本上。遇到一道新题就尝试理解，归类，翻出老题做对比，
 * 写code，看热门答案，更正、优化自己的答案，为什么他能想出这个解，搜一下相关不熟悉的知识点。

这个方法开始起步会特别慢，没有什么成就感。但是效果出奇的好，刷了一半，只要做过的题，
理解的十分透彻。遇到一个考到的算法或者数据结构，比如trie tree，就会回去看所有trie tree分类的题
，主要是看题目，回忆解法，如果想不起来或者不是很自信，再写一次。反之很熟悉，脑子里过一遍就继续下去。
看完trie tree也会想到Binary Search Tree, Segment Tree, Binary Index Tree。脑子里对这些数据结
构过一遍。

这样做题到后来的感觉就是，everything is connected. 随便给一个题，就能找出这
个题和什么题是类似的，或者其本质是这个算法的变形。简而言之，明确的感觉到，自己学懂了。

刷题是枯燥的，如果你想着用毅力用坚持，只会让它更枯燥。毅力是必须的但是坚持往往是
痛苦的，何不让这个过程变的快乐。这个年代人人都是千里马，但是伯乐不常有。我们只能做自己的伯乐，给自
己制定最合适的训练方法，因人而异因地制宜，自己既是“运动员”也是“教练”，毕竟还是自己最了解自己。时不时给
自己一些奖励，给自己放一个小假出去转转。

其实辛苦几个月，没那么难。和农民伯伯一样，种地是辛苦的，可是丰收是喜悦的。当你发现你
努力了一个月之后，做过的题可以得心应手，还可以给别人讲的头头是道，还是十分有成就感的。毕竟才几百道题嘛，
比上高考差远了。做到炉火纯青很难，但是得心应手还是指日可待的。
 */

public class Solution {

}
