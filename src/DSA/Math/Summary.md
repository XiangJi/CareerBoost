#  Math

1. 进位carry 越界num overflow 相加
2. 符号 sign 单独存储 用boolean
3. !Character.isDigit(s.charAt(i)); 判断是不是字母





```java
Reverse integer
int res;
while (nums != 0) {
    res = res * 10 + num % 10;
    num /= 10;
}
```



```java
class Solution {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min; //保证绝对在后面
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
    //每次和这之后的任意一个树swap
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
```



### Practice

Shuffle an array

valid squre

sort transformed array

Number of Corner rectangles