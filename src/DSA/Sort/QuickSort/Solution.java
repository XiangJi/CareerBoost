package DSA.Sort.QuickSort;


/*
 * 
 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot 
 * and partitions the given array around the picked pivot. There are many
 *  different versions of quickSort that pick pivot in different ways.

1. Always pick first element as pivot.
2. Always pick last element as pivot (implemented below)
3. Pick a random element as pivot.
4. Pick median as pivot.

The key process in quickSort is partition(). Target of partitions is, 
given an array and an element x of array as pivot, put x at its correct 
position in sorted array and put all smaller elements (smaller than x) 
before x, and put all greater elements 
(greater than x) after x. All this should be done in linear time.
 */

public class Solution {
    public static void quickSort(int[] array,int start,int end)
    {
        if(start < end)
        {
            int key = array[start];//初始化保存基元
            int i = start,j;//初始化i,j
            for(j = start + 1;j <= end;j++)
            {
                if(array[j]<key)//如果此处元素小于基元，则把此元素和i+1处元素交换，并将i加1，如大于或等于基元则继续循环
                {
                    int temp = array[j];
                    array[j] = array[i+1];
                    array[i+1] = temp;
                    i++;
                }
                
            }
            array[start] = array[i];//交换i处元素和基元
            array[i] = key;
            quickSort(array, start, i-1);//递归调用
            quickSort(array, i+1, end);
            
        }
        
    }
}
