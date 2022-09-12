package datastructure;


import java.util.Arrays;
import java.util.Stack;


public class MonotonicStack {
    /**
     * 请根据每日气温列表，重新生成一个列表。
     * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 输入：temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
     * 输出：[1, 1, 4, 2, 1, 1, 0, 0]
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.add(i);
        }

        return result;
    }

    /**
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     * <p>
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     */
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size * 2; i++) {
            while (!stack.isEmpty() && nums[i % size] > nums[stack.peek() % size]) {
                Integer index = stack.pop();
                result[index] = nums[i % size];
            }
            stack.add(i % size);
        }
        return result;
    }
}
