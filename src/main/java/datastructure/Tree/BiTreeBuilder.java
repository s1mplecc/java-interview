package datastructure.Tree;

import java.util.Arrays;

public class BiTreeBuilder {
    /**
     * 题目链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * <p>
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * inorder 和 postorder 都由 不同 的值组成；postorder 中每一个值都在 inorder 中。
     * <p>
     * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 输出：[3,9,20,null,null,15,7]
     */
    public TreeNode buildTreeByInPost(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;

        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        int splitIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                splitIndex = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, splitIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, splitIndex + 1, inorder.length);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, splitIndex);
        int[] rightPostorder = Arrays.copyOfRange(postorder, splitIndex, inorder.length - 1);

        root.left = buildTreeByInPost(leftInorder, leftPostorder);
        root.right = buildTreeByInPost(rightInorder, rightPostorder);

        return root;
    }

    /**
     * 题目链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * <p>
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     */
    public TreeNode buildTreeByPreIn(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int splitIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                splitIndex = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, splitIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, splitIndex + 1, inorder.length);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, splitIndex + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, splitIndex + 1, preorder.length);

        root.left = buildTreeByPreIn(leftPreorder, leftInorder);
        root.right = buildTreeByPreIn(rightPreorder, rightInorder);

        return root;
    }
}
