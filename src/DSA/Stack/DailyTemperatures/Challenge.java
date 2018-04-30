package DSA.Stack.DailyTemperatures;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Interview io OA, third farthest number
class Challenge {
    // BF
    public static Integer thirdFarthestDistance( List<Integer> arr,Integer x ) {
      Collections.sort(arr, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
          return Math.abs(b - x) - Math.abs(a - x);
        }
      });
      return arr.get(2);

    }
  }