package datastructure.Tree;

import java.util.*;


public class BiTree {

    /**
     * 前序遍历（递归）
     */
    public int[] preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        preorderRecur(root, preorder);
        return preorder.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void preorderRecur(TreeNode root, List<Integer> preorder) {
        if (root == null)
            return;
        preorder.add(root.val);
        preorderRecur(root.left, preorder);
        preorderRecur(root.right, preorder);
    }

    /**
     * 前序遍历（迭代）
     */
    public int[] preorderTraversalIterative(TreeNode root) {
        if (root == null)
            return new int[]{};

        ArrayList<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return preorder.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 中序遍历（递归）
     */
    public int[] inorderTraversal(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        inorderRecur(root, preorder);
        return preorder.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void inorderRecur(TreeNode root, List<Integer> inorder) {
        if (root == null)
            return;
        inorderRecur(root.left, inorder);
        inorder.add(root.val);
        inorderRecur(root.right, inorder);
    }

    /**
     * 中序遍历（迭代）
     */
    public int[] inorderTraversalIterative(TreeNode root) {
        if (root == null)
            return new int[0];

        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;  // 指针 + 栈

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                inorder.add(cur.val);
                cur = cur.right;
            }
        }

        return inorder.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 后序遍历（递归）
     */
    public int[] postorderTraversal(TreeNode root) {
        ArrayList<Integer> postorder = new ArrayList<>();
        postorderRecur(root, postorder);
        return postorder.stream().mapToInt(Integer::intValue).toArray();
    }

    private void postorderRecur(TreeNode root, List<Integer> postorder) {
        if (root == null)
            return;
        postorderRecur(root.left, postorder);
        postorderRecur(root.right, postorder);
        postorder.add(root.val);
    }

    /**
     * 后序遍历（迭代）
     */
    public int[] postorderTraversalIterative(TreeNode root) {
        if (root == null)
            return new int[0];

        ArrayList<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postorder.add(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }

        Collections.reverse(postorder);  // 逆序
        return postorder.stream().mapToInt(Integer::intValue).toArray();
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
}
