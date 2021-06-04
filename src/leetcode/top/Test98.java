package leetcode.top;

import entity.TreeNode;

public class Test98 {
//    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
// 假设一个二叉搜索树具有如下特征：
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。

    //设计一个递归函数 helper(root, lower, upper) 来递归判断，函数表示考虑以
    // root 为根的子树，判断子树中所有节点的值是否都在 (l,r) 的范围内（注意是开区间）。
    public boolean isValidBST(TreeNode root) {
        // 节点的子节点值 大于l，小于r
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public static void main(String[] args) {

    }

}
