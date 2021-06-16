package leetcode.top;

public class Test96 {
    //    给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
    // 题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
    // G(n): 长度为n的序列能构成的不同二叉搜索树的个数。
    // F(i,n): 以i为根、序列长度为n的不同二叉搜索树个数(1≤i≤n)。
    //稍后我们将看到，G(n)G(n) 可以从 F(i, n)F(i,n) 得到，而 F(i, n)F(i,n) 又会递归地依赖于 G(n)G(n)。
    // G(n)=F(1,n)+F(2,n)+F(3,n)+...+F(n,n)
    //F(i,n)=G(i−1)⋅G(n−i)，从左右子序列中可以构造成笛卡尔积（n*m）
    // 举例而言，创建以 33 为根、长度为 77 的不同二叉搜索树，整个序列是 [1, 2, 3, 4, 5, 6, 7][1,2,3,4,5,6,7]，
    // 我们需要从左子序列 [1, 2][1,2] 构建左子树，从右子序列 [4, 5, 6, 7][4,5,6,7] 构建右子树，然后将它们组合（即笛卡尔积）。
    // 所有G(n)=G(1-1)*G(n-1)+G(2-1)*G(n-2)+..+
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        Test96 t = new Test96();
        int i = t.numTrees(3);
        System.out.println(i);
    }
}
