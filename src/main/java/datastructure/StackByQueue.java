package datastructure;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class StackByQueue {
    private Queue<Integer>[] queues = new Queue[2];
    private int switchIndex;

    public StackByQueue() {
        queues[0] = new ArrayDeque<Integer>();
        queues[1] = new ArrayDeque<Integer>();
        switchIndex = 0;
    }

    public void push(int x) {
        queues[switchIndex].add(x);
    }

    public int pop() {
        if (queues[switchIndex].size() == 0)
            return -1;

        while (queues[switchIndex].size() > 1) {
            queues[1 - switchIndex].add(queues[switchIndex].remove());
        }
        // last one
        Integer top = queues[switchIndex].remove();
        switchIndex = 1 - switchIndex;
        return top;
    }

    public int top() {
        if (queues[switchIndex].size() == 0)
            return -1;

        while (queues[switchIndex].size() > 1) {
            queues[1 - switchIndex].add(queues[switchIndex].remove());
        }

        return queues[switchIndex].element();
    }

    public boolean empty() {
        return queues[0].isEmpty() && queues[1].isEmpty();
    }
}
