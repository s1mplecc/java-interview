package datastructure;

import java.util.*;


public class BiTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param preOrder int整型ArrayList
     * @param inOrder  int整型ArrayList
     * @return TreeNode类ArrayList
     */
    public ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        ArrayList<TreeNode> result = new ArrayList<>();
        TreeNode root = new TreeNode(preOrder.get(0));
        ArrayList<Integer> splitIndex = new ArrayList<>();
        for (int i = 0; i < preOrder.size(); i++) {
            if (inOrder.get(i) == root.val) {
                splitIndex.add(i);
            }
        }
        for (Integer index : splitIndex) {
            ArrayList<Integer> leftTreeInOrder = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                leftTreeInOrder.add(inOrder.get(i));
            }
            ArrayList<Integer> rightTreeInOrder = new ArrayList<>();
            for (int i = index + 1; i < inOrder.size(); i++) {
                rightTreeInOrder.add(inOrder.get(i));
            }

        }
        return null;
    }

    private ArrayList<TreeNode> recurBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, TreeNode root, ArrayList<TreeNode> result) {
        if (preOrder.size() == 2 && Objects.equals(preOrder.get(0), inOrder.get(0))) {
            new ArrayList<>(result);
        }
        return null;
    }

    /**
     * 前序遍历
     *
     * @return [1, 2, 3, 4, 5]
     */
    public int[] preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        recurPreOrder(root, preorder);
        return preorder.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void recurPreOrder(TreeNode root, List<Integer> preOrder) {
        if (root == null)
            return;
        preOrder.add(root.val);
        recurPreOrder(root.left, preOrder);
        recurPreOrder(root.right, preOrder);
    }

    /**
     * 层序遍历
     *
     * @return [[1], [2, 3], [4, 5]]
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> curLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            levelOrder.add(curLevel);
        }
        return levelOrder;
    }


    /**
     * 之字遍历
     *
     * @return [[1], [3, 2], [4, 5, 6, 7]]
     */
    public ArrayList<ArrayList<Integer>> zOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            ArrayDeque<Integer> curLevel = new ArrayDeque<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

                if (leftToRight)
                    curLevel.addLast(node.val);
                else
                    curLevel.addFirst(node.val);
            }
            levelOrder.add(new ArrayList<>(curLevel));
            leftToRight = !leftToRight;
        }
        return levelOrder;
    }

    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
