package leetcode.top;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test94 {
    //    94. 二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traversal(root.left, result);
        result.add(root.val);
        traversal(root.right, result);
    }

    public static void main(String[] args) {
        Test94 t = new Test94();
        //[1, 3, 2]
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        List<Integer> integers = t.inorderTraversal(t1);
        System.out.println(integers);
    }
}
