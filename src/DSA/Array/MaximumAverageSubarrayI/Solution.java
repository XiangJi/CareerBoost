package DSA.Array.MaximumAverageSubarrayI;

class Solution {
    // Brute force: O(nk)
    public double findMaxAverageBF(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            double avg = sum / k;
            max = Math.max(max,avg);
        }
        return max;
    }

    // Sliding window O(n)
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;

        // index i is the end index of subarray
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / (double) k;
    }
}