package datastructure;

import java.util.*;


public class BiTree {

    /**
     * 前序遍历
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
