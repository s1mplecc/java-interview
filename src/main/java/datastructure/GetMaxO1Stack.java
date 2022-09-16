package datastructure;

import java.util.Stack;

/**
 * 支持 getMax O(1) 复杂度的栈
 */
public class GetMaxO1Stack {
    private final Stack<Integer> stack;
    private final Stack<Pair> increaseStack;
    private int size;

    public GetMaxO1Stack() {
        stack = new Stack<>();
        increaseStack = new Stack<>();
        size = 0;
    }

    public void push(int val) {
        size++;
        stack.push(val);
        if (increaseStack.isEmpty()) {
            increaseStack.push(new Pair(1, val));
        } else {
            Pair top = increaseStack.peek();
            if (val >= top.val)
                increaseStack.push(new Pair(size, val));
        }
    }

    public int pop() {
        if (size == 0)
            return -1;

        size--;
        Pair top = increaseStack.peek();
        if (size < top.index)
            increaseStack.pop();

        return stack.pop();
    }

    public int getMax() {
        if (size == 0)
            return -1;
        return increaseStack.peek().val;
    }

    private static class Pair {
        int index;
        int val;

        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
