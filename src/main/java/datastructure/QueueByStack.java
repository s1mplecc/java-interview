package datastructure;

import java.util.Stack;

/**
 * 使用栈实现队列的下列操作：
 * <p>
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class QueueByStack {
    private final Stack<Integer> stackIn;
    private final Stack<Integer> stackOut;

    public QueueByStack() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        if (!stackOut.isEmpty())
            return stackOut.pop();
        dumpInToOut();
        return stackOut.isEmpty() ? -1 : stackOut.pop();
    }

    public int peek() {
        if (!stackOut.isEmpty())
            return stackOut.peek();
        dumpInToOut();
        return stackOut.isEmpty() ? -1 : stackOut.peek();
    }

    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void dumpInToOut() {
        if (stackIn.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
