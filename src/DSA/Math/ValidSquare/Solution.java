package DSA.Math.ValidSquare;

import java.util.Arrays;

/*
 * 题目要求我们判断四个点能否组成正方形，那么正方形有哪些特征呢。我们容易想到，正方形四条边长
 * 度都相等，并且两条对角线长度也相等，所以，我们只要求出这四个点两两之间的距离，进行从小到大排序之
 * 后，如果这四个点能构成正方形，那么前面四个数就是四条边长的长度，后面两个数为两条对角线的长度，因
 * 此我们只需要判断前四个数以及后两个数它们是否相等即可。这题为避免四个点重叠，因此我们还需要判断一
 * 下对角线长度是否大于边长即可。
 */
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int p[][]={{p1[0],p1[1]},{p2[0],p2[1]},{p3[0],p3[1]},{p4[0],p4[1]}};
        int [] len;
        int cnt = 0;
        len=new int[6];
        for(int i = 0;i < 4;i++){
            for(int j = i + 1;j < 4;j++){
                len[cnt++]=(p[i][0] - p[j][0])*(p[i][0] - p[j][0])+(p[i][1] - p[j][1])*(p[i][1] - p[j][1]);
            }
        }
        Arrays.sort(len);
        if(len[0] == len[3] && len[4] == len[5] && len[4] > len[0]){
            return true;
        }
        else{
            return false;
        }
    }
}