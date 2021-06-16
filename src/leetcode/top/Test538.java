package leetcode.top;

import entity.TreeNode;

public class Test538 {
    //给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
    // 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
    // 提醒一下，二叉搜索树满足下列约束条件：
    // 节点的左子树仅包含键 小于 节点键的节点。
    // 节点的右子树仅包含键 大于 节点键的节点。
    // 左右子树也必须是二叉搜索树
    //
    //思路及算法
    //
    // 本题中要求我们将每个节点的值修改为原来的节点值加上所有大于它的节点值之和。这样我们只需要反序中序遍历该二叉搜索树，
    // 记录过程中的节点值之和，并不断更新当前遍历到的节点的节点值，即可得到题目要求的累加树。
    //
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


    public static void main(String[] args) {
        Test538 t=new Test538();
        // t.convertBST();
    }
}
