package DSA.Queue.ImplementStackusingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queueA = new LinkedList<Integer>(); // queue是虚类在java里
    // Push element x onto stack.
    public void push(int x) {
        queueA.offer(x);
    }

    // Removes the element on top of the stack.
    // 将queue中所有元素pop from front然后push to back，使用辅助变量top记录每次弹出的元素，返回
    public void pop() {
        int temp;
        int currentSize = queueA.size();
        while(currentSize > 1) {

                temp = queueA.poll();
                queueA.offer(temp);
                currentSize--;
        }

        queueA.poll();
    }

    // Get the top element.
    // 将queue中所有元素pop from front然后push to back，使用辅助变量top记录每次弹出的元素，返回
    public int top() {
        int temp = -1;
        int currentSize = queueA.size();
        while(currentSize > 0) {

                temp = queueA.poll();
                queueA.offer(temp);
                currentSize--;
        }
        return temp;

    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (queueA.size() == 0) {
                return true;
        }
        return false;
    }
}