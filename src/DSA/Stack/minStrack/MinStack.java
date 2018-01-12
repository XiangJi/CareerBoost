package DSA.Stack.minStrack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack ;
    private Stack<Integer> mintracker;
    public MinStack() {
        stack = new Stack<Integer>();
        mintracker = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (mintracker.empty()) {
            mintracker.push(number);
        } else {
            if (number >= mintracker.peek()) {
                mintracker.push(mintracker.peek());
            } else {
                mintracker.push(number);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int pop() {
        mintracker.pop();
        return stack.pop();
    }

    public int getMin() {
        return mintracker.peek();
    }
}

