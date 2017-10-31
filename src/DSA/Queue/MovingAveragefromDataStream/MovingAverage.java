package DSA.Queue.MovingAveragefromDataStream;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    /** Initialize your data structure here. */
    // use rolling array to store sum's delta
    Queue<Integer> slidingWindow = new LinkedList<Integer>();
    int windowSize;
    
    public MovingAverage(int size) {
        windowSize = size;
    }
    
    public double next(int val) {
        if (slidingWindow.size() < windowSize) {
            slidingWindow.offer(val);
        } else {
            slidingWindow.poll();
            slidingWindow.offer(val);
        }
        
        // Pop all and calculate average
        int sum = 0;
        for (int num : slidingWindow) {
            sum += num;
        }
        return  sum / (double) (slidingWindow.size());
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    /**
	     * Your MovingAverage object will be instantiated and called as such:
	     * MovingAverage obj = new MovingAverage(size);
	     * double param_1 = obj.next(val);
	     */

	}
}

class MovingAverage2 {

    double[] sum;
    int id, size;
    
    /** Initialize your data structure here. */
    public MovingAverage2(int s) {
        sum = new double[s + 1];
        id = 0;
        size = s;
    }
    
    // rolling array template
    int mod(int x) {
        return x % (size + 1);
    }
    
    public double next(int val) {
        id++;
        sum[mod(id)] = sum[mod(id - 1)] + val;
        if (id - size >= 0) {
            return (sum[mod(id)] - sum[mod(id - size)]) / size;
        } else {
            return sum[mod(id)] / id;
        }
    }
}
