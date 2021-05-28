package leetcode.top;

public class Test416 {
    // 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    // 输入：nums = [1,5,11,5]
    // 输出：true
    // 解释：数组可以分割成 [1, 5, 5] 和 [11] 。

    //背包问题：由题目可以分析出来-> 长度必须大于2，不然不能继续分，所有元素和必须为偶数，不然不能对半分，
    // 目标值为所有元素和的一半，最大值不能大于和的一半
    //https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;//长度小于2直接返回false
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false; //获取最大值和总和，总和必须是偶数
        }
        int target = sum / 2;//获取目标值，为总和的一半，因为要对半
        if (maxNum > target) {
            return false;//最大值如果对大于目标值，直接false
        }

        //动态规划：定义创建二维数组dp，包含n行target+1 列，其中dp[i][j] 表示从数组的[0,i]下标范围内选取若干个正整数（可以是0个），
        // 是否存在一种选取方案使得 被选取的正整数的和 等于j
        boolean[][] dp = new boolean[n][target + 1]; //需要理解他的定义
        //初始化边界：如果不选取任何正整数，则被选取的正整数等于0。因此对于所有0≤i<n，都有dp[i][0]=true。
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;//当 i==0时，只有一个正整数nums[0] 可以被选取，因此dp[0][nums[0]]=true。

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {     //注意，数组下标必须大于0，所以j>=num，这个情况下转移方程有选取num[i]和不选取num[i]两种
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];//所以这里用| 来做或运算
                } else {
                    dp[i][j] = dp[i - 1][j];    //无法选取当前的数字nums[i]，因此有 dp[i][j]=dp[i−1][j]。
                }
            }
        }
        return dp[n - 1][target];//最终得到 dp[n−1][target] 即为答案。
    }

    public static void main(String[] args) {
        Test416 t = new Test416();
        int[] nums = {1, 5, 11, 5};
        boolean b = t.canPartition(nums);
        System.out.println(b);
    }
}
