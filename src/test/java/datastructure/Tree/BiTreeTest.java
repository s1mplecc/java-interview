package datastructure.Tree;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BiTreeTest {
    private TreeNode root;

    @Before
    public void setUp() throws Exception {
        BiTreeBuilder builder = new BiTreeBuilder();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        root = builder.buildTreeByPreIn(preorder, inorder);
    }

    @Test
    public void should_return_preorder_traversal() {
        BiTree biTree = new BiTree();

        assertThat(biTree.preorderTraversal(root)).containsExactly(3, 9, 20, 15, 7);
        assertThat(biTree.preorderTraversalIterative(root)).containsExactly(3, 9, 20, 15, 7);
    }

    @Test
    public void should_return_inorder_traversal() {
        BiTree biTree = new BiTree();

        assertThat(biTree.inorderTraversal(root)).containsExactly(9, 3, 15, 20, 7);
        assertThat(biTree.inorderTraversalIterative(root)).containsExactly(9, 3, 15, 20, 7);
    }

    @Test
    public void should_return_postorder_traversal() {
        BiTree biTree = new BiTree();

        assertThat(biTree.postorderTraversal(root)).containsExactly(9, 15, 7, 20, 3);
        assertThat(biTree.postorderTraversalIterative(root)).containsExactly(9, 15, 7, 20, 3);
    }
}