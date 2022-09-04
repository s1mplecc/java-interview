package datastructure;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private final List<Integer> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public PriorityQueue(int... values) {
        this.queue = new ArrayList<>();
        for (int value : values) {
            this.enqueue(value);
        }
    }

    public void enqueue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.valueOf(value));
        }

        queue.add(value);
        int index = queue.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (queue.get(index) > queue.get(parentIndex)) {
                this.swap(index, parentIndex);
            }
            index = parentIndex;
        }
    }

    public int dequeue() {
        if (queue.size() == 0)
            return -1;
        if (queue.size() == 1)
            return queue.remove(0);

        int value = queue.get(0);
        int last = queue.remove(queue.size() - 1);
        int index = 0;
        queue.set(0, last);

        while (index < queue.size() / 2) {
            int leftIndex = (index << 1) + 1;
            int rightIndex = (index << 1) + 2;
            if (rightIndex >= queue.size()) {
                if (queue.get(leftIndex) > queue.get(index)) {
                    this.swap(index, leftIndex);
                }
                break;
            }
            if (queue.get(index) >= queue.get(leftIndex) && queue.get(index) >= queue.get(rightIndex))
                break;
            if (queue.get(leftIndex) >= queue.get(rightIndex)) {
                this.swap(leftIndex, index);
                index = leftIndex;
            } else {
                this.swap(rightIndex, index);
                index = rightIndex;
            }
        }

        return value;
    }

    private void swap(int i, int j) {
        int tmp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, tmp);
    }

    public List<Integer> queue() {
        return queue;
    }
}
