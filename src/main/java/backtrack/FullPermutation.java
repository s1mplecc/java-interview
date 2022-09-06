package backtrack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    public List<List<Integer>> sequences() {
        List<Integer> nums = Arrays.stream(this.nums)
                .boxed()
                .collect(Collectors.toList());
        backTracing(nums, new ArrayList<>());
        return permutations;
    }

    private void backTracing(List<Integer> remain, List<Integer> current) {
        if (remain.size() == 0) {
            permutations.add(current);
        }
        for (int i = 0; i < remain.size(); i++) {
            List<Integer> forkRemain = new ArrayList<>(remain);
            List<Integer> forkCurrent = new ArrayList<>(current);
            forkCurrent.add(forkRemain.remove(i));
            backTracing(forkRemain, forkCurrent);
        }
    }
}
