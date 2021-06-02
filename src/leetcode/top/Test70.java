package leetcode.top;

public class Test70 {
    // 动态规划
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
