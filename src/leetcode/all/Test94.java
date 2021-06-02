package leetcode.all;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test94 {
    //    94. 二叉树的中序遍历
//    给定一个二叉树的根节点 root ，返回它的 中序 遍历。
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();//定义一个存放结果的数组
        inorder(root, res);
        return res;
    }

    //二叉树的中序遍历：按照访问左子树——根节点——右子树的方式遍历这棵树
    public void inorder(TreeNode root, List<Integer> res) {//定义递归函数，根节点的值存放到结果集和中，就算访问了
        if (root == null) {//递归结束条件，为空的话返回，不走下面
            return;
        }
        inorder(root.left, res);//先左子树
        res.add(root.val);// 根节点
        inorder(root.right, res);//右子树
    }

    public static void main(String[] args) {
        Test94 t = new Test94();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2;
        t2.left = t3;
        t.inorderTraversal(t1);
    }
}
