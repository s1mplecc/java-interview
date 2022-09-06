package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]
 **/
public class BracketPairConstructor {
    public List<String> bracketPairs(int n) {
        List<String> pairs = new ArrayList<>();
        backTracing(n, n, "", pairs);
        return pairs;
    }

    private void backTracing(int leftRemain, int rightRemain, String curString, List<String> result) {
        if (leftRemain == 0 && rightRemain == 0)
            result.add(curString);
        if (leftRemain != 0) {
            backTracing(leftRemain - 1, rightRemain, curString + '(', result);
        }
        if (rightRemain != 0 && rightRemain > leftRemain) {
            backTracing(leftRemain, rightRemain - 1, curString + ')', result);
        }
    }
}
