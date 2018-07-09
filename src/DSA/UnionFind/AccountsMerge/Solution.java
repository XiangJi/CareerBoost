package DSA.UnionFind.AccountsMerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
 * 都是要用一个root数组，每个点开始初始化为不同的值，如果两个点属于相同的组，就将其中一个点的root值赋值为另一个点的位置，这样只要是相同组
 * 里的两点，通过find函数得到相同的值。在这里，由于邮件是字符串不是数字，所以root可以用哈希map来代替，我们还需要一个哈希映射owner，建立
 * 每个邮箱和其所有者姓名之前的映射，另外用一个哈希映射来建立用户和其所有的邮箱之间的映射，也就是合并后的结果。
 * 首先我们遍历每个账户和其中的所有邮箱，先将每个邮箱的root映射为其自身，然后将owner赋值为用户名。然后开始另一个循环，遍历每一个账号，首先
 * 对帐号的第一个邮箱调用find函数，得到其父串p，然后遍历之后的邮箱，对每个遍历到的邮箱先调用find函数，将其父串的root值赋值为p，这样做相
 * 当于将相同账号内的所有邮箱都链接起来了。我们下来要做的就是再次遍历每个账户内的所有邮箱，先对该邮箱调用find函数，找到父串，然后将该邮箱加
 * 入该父串映射的集合汇总，这样就我们就完成了合并。最后只需要将集合转为字符串数组，加入结果res中，通过owner映射找到父串的用户名，加入字符
 * 串数组的首位置
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}