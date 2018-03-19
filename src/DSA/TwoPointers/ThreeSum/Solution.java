package DSA.TwoPointers.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

T: o(N ^ 2)
S: o(N)
Two pointers
 */
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
                return result;
        }

        Arrays.sort(num); // input is an array not an arrayList
        for (int i = 0; i < num.length - 2; i++) {
                if (i != 0 && num[i] == num[i - 1]) {
                        continue; // for skip duplicate numbers;
                }

                int left = i + 1;
                int right = num.length - 1;
                while (left < right) {
                        int sum = num[left] + num[right] + num[i];
                        if (sum == 0) {
                                ArrayList<Integer> tmp = new ArrayList<Integer>();
                                tmp.add(num[i]);
                                tmp.add(num[left]);
                                tmp.add(num[right]);
                                result.add(tmp);
                                left++;
                                right--;
                                while (left < right && num[left] == num[left - 1]) {
                                        left++; // skip the duplicate
                                }
                                while (left < right && num[right] == num[right + 1]) {
                                        right--;
                                }
                        } else if (sum < 0) {
                                left++;
                        } else if (sum > 0) {
                                right--;
                        }
                }

        }
        return result;

    }
}
