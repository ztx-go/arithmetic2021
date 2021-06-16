package leetcode.all;

public class Test494 {
//    给你一个整数数组 nums 和一个整数 target 。
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

    public int findTargetSumWays(int[] nums, int target) {

        char[] find = new char[]{'+', '-'};
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < find.length; j++) {

                temp = temp + (find[j] + nums[i]);
            }
            if (temp == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test494 t = new Test494();
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int target = t.findTargetSumWays(arr, 3);
        System.out.println(target);
    }

}
