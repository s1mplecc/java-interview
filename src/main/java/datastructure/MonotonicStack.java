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


    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水。
     */
    public int catchRain(int[] height) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> lowLayer = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0)
                continue;
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int lastIndex = stack.pop();
                result += height[lastIndex] * (i - lastIndex - 1);
                if (!lowLayer.isEmpty()) {
                    result -= lowLayer.pop();
                }
                if (!stack.isEmpty())
                    lowLayer.add(height[lastIndex] * (i - lastIndex + 1));
            }
            stack.add(i);
        }
        return result;
    }

    public int catchRainByDP(int[] height) {
        int size = height.length;
        int[] dp1 = new int[size];
        dp1[0] = 0;
        int[] dp2 = new int[size];
        dp2[size - 1] = 0;
        for (int i = 1; i < size; i++) {
            dp1[i] = Math.max(dp1[i - 1], height[i - 1]);
        }
        for (int i = size - 2; i >= 0 ; i--) {
            dp2[i] = Math.max(dp2[i + 1], height[i + 1]);
        }

        int result = 0;
        for (int i = 1; i < size - 1; i++) {
            result += Math.max(0, Math.min(dp1[i], dp2[i]) - height[i]);
        }

        return result;
    }
}
