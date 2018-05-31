package DSA.Math.RandomRectangles;
/*
 * given a list of rectangles, write a method to choose a random point uniformly in the list of rectangles （maybe overlapped）
 * 每个长方形面积不一样，但是你要取个点，这个点可以是任何长方形里的。但是要你每次取点的概率都是一样的。不会因为长方形大小而不同。
 *
 * 在一个矩形中生成一个随机点。矩形由左下角坐标和长宽表示。第一问矩形坐标是整形，第二问是浮点，第三问还是浮点，如果有很多矩形怎么办（可以有overlap，主要难度在如何处理overlap）
 *
 *
 *assume 每个长方形不重叠。 先按照面积（建一个prefix sum数组）， 随机得到一个矩形。 再按照那个矩形的长和宽随机得到一个点。
 *
 *有rand函数生成一个0-1随机分布的数，要求
1. 在一个长方形内产生一个点（均匀分布）easy

2. 有一系列长方形（互不重叠），产生一个，比列按照面积来，比如AB两个面积比为3
:1，那么落在A内比列要75%，然后随机产生一个点
这个也不难，先算各个面积所占比例，用rand函数产生一个随机数，二分法查找落在哪
个区间，然后call 1函数

3. 如果有重叠怎么办?

线段树扫描线分割成小矩形

 */
public class Solution {

}
