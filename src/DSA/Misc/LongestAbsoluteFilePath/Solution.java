package DSA.Misc.LongestAbsoluteFilePath;

import java.util.HashMap;

/**
 * Suppose we abstract our file system by a string in the following manner:
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * ...
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 * Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
 * Note:
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a ..
 * Time complexity required: O(n) where n is the size of the input string.
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class Solution {
    /*
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // Write your code here
        if (input.length() == 0) {
            return 0;
        }
        int ans = 0;
        // store the level and the length of path to level
        HashMap<Integer, Integer> map = new  HashMap<Integer, Integer>();
        map.put(0, 0);
        for (String line : input.split("\n")) {
            // read this line, get the nth 
            System.out.println(line);
            // \t is considered as one char
            int level = line.lastIndexOf('\t') + 1;
            System.out.println(level);
            // get this line's length
            int len = line.length() - level;
            System.out.println(len);
            if (line.contains(".")) {
                ans = Math.max(ans, map.get(level) + len);
            } else {
                map.put(level + 1, map.get(level) + len + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        
    }
}
  
