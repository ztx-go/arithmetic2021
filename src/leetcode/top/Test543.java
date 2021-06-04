package leetcode.top;

import entity.TreeNode;

public class Test543 {
    //给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点
    // 路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

    int ans;//定义一个全局变量；用来记录最长的路径

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;//注意这里需要-1
    }

    //定义一个递归函数：返回该根节点的子树的深度
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 每一次都计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    public static void main(String[] args) {
        Test543 t = new Test543();
        //返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t.diameterOfBinaryTree(t1);
    }
}
