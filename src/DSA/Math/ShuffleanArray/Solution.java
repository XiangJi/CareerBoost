package DSA.Math.ShuffleanArray;

/*
 * Shuffle a set of numbers without duplicates.


Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
Fisher-Yates Algorithm [Accepted]
Intuition

We can cut down the time and space complexities of shuffle with a bit of cleverness - namely, by swapping elements around within the array itself, we can avoid the linear space cost of the auxiliary array and the linear time cost of list modification.

Algorithm

The Fisher-Yates algorithm is remarkably similar to 
the brute force solution. On each iteration of the algorithm, we 
generate a random integer between the current index and the last index of
 the array. Then, we swap the elements at the current index and the chosen 
 index - this simulates drawing (and removing) the element from the hat, as the
  next range from which we select a random index will not include the most rec
  ently processed one. One small, yet important detail is that it is possible 
  to swap an element with itself - otherwise, some array permutations would
   be more likely than others. To see this illustrated more clearly
   
   O(n)

 面经 shuffle一个树
 先serilized 成数组 然后shuffle 然后deserizle回去

对于每人i 和之后随即范围一个树swap
Fisher Yates O（n）
 */
import java.util.Random;

class Solution {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}