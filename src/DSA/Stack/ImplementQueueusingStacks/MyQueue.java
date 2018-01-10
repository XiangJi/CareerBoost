package DSA.Stack.ImplementQueueusingStacks;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void stackTransfer() {
        while(!stack1.empty()) {
            stack2.push(stack1.peek());
            stack1.pop();
        }
    }

    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack2.empty()) {
            this.stackTransfer();
        }
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack2.empty()) {
            this.stackTransfer();
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (stack1.empty() && stack2.empty()) {
            return true;
        }
        return false;
    }
}