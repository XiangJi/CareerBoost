package DSA.DFS.PyramidTransitionMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

Return true if we can build the pyramid all the way to the top, otherwise false.

Example 1:
Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
Output: true
Explanation:
We can stack the pyramid like this:
    A
   / \
  D   E
 / \ / \
X   Y   Z

This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
Example 2:
Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
Output: false
Explanation:
We can't stack the pyramid to the top.
Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
Note:
bottom will be a string with length in range [2, 8].
allowed will have length in range [0, 200].
Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.

，比如“ABD”也可以同时出现，不过搭积木的时候只能选择一种。给了我们一个bottom字符串，
是金字塔的底层，问我们能不能搭出一个完整的金字塔。那么实际上我们就是从底层开始，一层一层的向上来累
加，直到搭出整个金字塔。我们先来看递归的解法，首先由于我们想快速知道两个字母上方可以放的字母，需要建立基座
字符串和上方字符集合之间的映射，由于上方字符可以不唯一，所以用个HashSet来放字符。我们的递归函数有三个参
，当前层字符串cur，上层字符串above，还有我们的HashMap。如果cur的大小为2，above的大小为1，那么说明当前已
经达到金字塔的顶端了，已经搭出来了，直接返回true。否则看，如果上一层的长度比当前层的长度正好小一个，说明上
一层也搭好了，我们现在去搭上上层，于是调用递归函数，将above当作当前层，空字符串为上一层，将调用的递归函数
结果直接返回。否则表示我们还需要继续去搭above层，我们先算出above层的长度pos，然后从当前层的pos位置开始
取两个字符，就是above层接下来需要搭的字符的基座字符，举个例子如下：

  D
 / \ / \
A   B   C
我们看到现在above层只有一个D，那么pos为1，在cur层1位置开始取两个字符，得到"BC"，即是D的下一个
位置的字符的基座字符串base。取出了base后，如果HashMap中有映射，则我们遍历其映射的字符集合中的所
有字符，对每个字符都调用递归函数，此时above字符串需要加上这个遍历到的字符，因为我们在尝试填充这个
位置，如果有返回true的，那么当前递归函数就返回true了，否则最终返回false，

 */
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : allowed) {
            String key = s.substring(0, 2);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s.substring(2));
        }
        return dfs(bottom, 0, "", map);
    }

    private boolean dfs(String bottom, int idx, String upper, Map<String, List<String>> map) {
        if(bottom.length() == 1) return true;

        if(idx == bottom.length() - 1) {
            return dfs(upper, 0, "", map);
        }

        if(idx == 0) { // check if allowed rules to save recursion effort and return false early
            for(int i=0; i<bottom.length()-1; i++) {
                if(!map.containsKey(bottom.substring(i, i+2))) return false;
            }
        }

        for(String s : map.get(bottom.substring(idx, idx+2))) {
            if(dfs(bottom, idx+1, upper+s, map)) return true;
        }

        return false;
    }
}
