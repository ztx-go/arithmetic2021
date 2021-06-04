package leetcode.top;

import entity.TreeNode;

public class Test617 {
    //    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为
// 节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。

    //  递归的方式进行遍历
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) { //递归结束条件，t1为空，返回t2
            return t2;
        }
        if (t2 == null) {//递归结束条件，t2为空，返回t1
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);//新建节点
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;//返回这个节点
    }

    public static void main(String[] args) {

    }
}
