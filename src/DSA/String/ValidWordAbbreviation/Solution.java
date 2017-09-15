package DSA.String.ValidWordAbbreviation;

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        char[] wd = word.toCharArray();
        char[] ab =abbr.toCharArray();
        while (i < word.length() && j < abbr.length()) {
            if (wd[i] == ab[j]) {
                i++;
                j++;
                continue;
            }
            // test case, 'a', '01'
            if (ab[j] <= '0' || ab[j] > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && ab[j] >= '0' && ab[j] <= '9') {
                j++;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }

        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        String a = "internationalization";
        String b = "i12iz4n";
        Solution test = new Solution();
        test.validWordAbbreviation(a, b);
    }

}