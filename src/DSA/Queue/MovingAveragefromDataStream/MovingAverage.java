package DSA.Queue.MovingAveragefromDataStream;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    /** Initialize your data structure here. */
    
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
