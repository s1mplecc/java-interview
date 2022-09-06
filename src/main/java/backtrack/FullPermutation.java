package backtrack;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class FullPermutation {

    private final List<List<Integer>> permutations;
    private final int[] nums;

    public FullPermutation(int[] nums) {
        this.nums = nums;
        this.permutations = new ArrayList<>();
        ;
    }

    public List<List<Integer>> sequences() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backTracing(list, new ArrayList<>());
        return permutations;
    }

    private void backTracing(List<Integer> remain, List<Integer> current) {
        if (remain.size() == 0) {
            permutations.add(current);
        }
        for (int i = 0; i < remain.size(); i++) {
            List<Integer> newRemain = new ArrayList<>(remain);
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(newRemain.remove(i));
            backTracing(newRemain, newCurrent);
        }
    }
}
