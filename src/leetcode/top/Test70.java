package leetcode.top;

public class Test70 {
    // 动态规划
    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    // 注意：给定 n 是一个正整数。
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];//转移方程
        }
        return dp[n - 1];
    }

    //     但是由于这里的 f(x) 只和f(x−1) 与f(x−2) 有关，所以我们可以用「滚动数组思想」把空间复杂度优化成O(1)。
    //
    //         int p = 0, q = 0, r = 1;
    //         for (int i = 1; i <= n; ++i) {
    //             p = q;
    //             q = r;
    //             r = p + q;
    //         }
    //         return r;
    //

    public static void main(String[] args) {
        Test70 t = new Test70();
        int i = t.climbStairs(3);
        System.out.println(i);
    }
}
