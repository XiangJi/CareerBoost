package DSA.Sort.ArrangeNumbersToLargest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static String constructLargestNumber(List<String> list) {
       
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String X = a + b;
                String Y = b + a;
                return Integer.valueOf(Y) - Integer.valueOf(X);
                //return Y.compareTo(X) > 0 ? 1: - 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String num : list) {
          sb.append(num);
        }
        return sb.toString();
      }
      
      public static void main(String[] args) {
          List<String> list = Arrays.asList("1", "3", "2", "5", "6");
        System.out.println(constructLargestNumber(list));
     
      }
}
