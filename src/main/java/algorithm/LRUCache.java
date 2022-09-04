package algorithm;

import java.util.HashMap;
import java.util.LinkedList;

// least recently used: 缓存淘汰/页面置换
public class LRUCache {
    private HashMap<Integer, Integer> map;
    private final LinkedList<Integer> queue;

    public LRUCache() {
        queue = new LinkedList<>();
    }

    public void enqueue(int id) {
        if (!queue.contains(id)) {
            queue.addLast(id);
        } else {
            int remove = queue.remove(queue.indexOf(id));
            queue.addLast(remove);
        }
    }

    public int dequeue() {
        if (queue.size() == 0)
            return -1;
        return queue.pollFirst();
    }

    public LinkedList<Integer> queue() {
        return queue;
    }
}
