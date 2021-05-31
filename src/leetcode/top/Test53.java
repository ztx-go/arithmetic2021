package leetcode.top;

import java.util.Arrays;

public class Test53 {

    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    // 输出：6
    // 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.max(arr[i - 1] + nums[i], nums[i]);//转移方程，加上当前数和当前数哪个最大，得到当前位置的最大连续子数组和
            max = Math.max(max, arr[i]);// 选出最大的值
            System.out.println(Arrays.toString(arr));
        }
        return max;
        //考虑到 f(i)f(i) 只和 f(i-1)f(i−1) 相关，于是我们可以只用一个变量pre 来维护对于当前
        // f(i)的f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。
        //
        //      int pre = 0, maxAns = nums[0];
        //         for (int x : nums) {
        //             pre = Math.max(pre + x, x);
        //             maxAns = Math.max(maxAns, pre);
        //         }
        //         return maxAns
        //
    }

    public static void main(String[] args) {
        Test53 t = new Test53();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = t.maxSubArray(arr);
        System.out.println(i);
    }
}
