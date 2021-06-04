package leetcode.top;

import entity.TreeNode;

public class Test226 {
    //    226. 翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {//递归终止条件，为空的时候返回
            return root;
        }
        TreeNode leftNode = invertTree(root.right);//递归，传入root.right返回root.right节点
        TreeNode rightNode = invertTree(root.left);//递归，传入root.left返回root.left
        root.left = leftNode;//进行翻转
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        Test226 t = new Test226();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode treeNode = t.invertTree(t1);
        System.out.println(treeNode);
    }
}
