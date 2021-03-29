package leetcode.medium;

public class OneNineEightRobber {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            arr[i] = Math.max(nums[i] + arr[i - 2], arr[i - 1]);
        }
        return arr[nums.length - 1];
    }

    public static void main(String[] args) {
        OneNineEightRobber t = new OneNineEightRobber();
        int[] n = new int[]{2, 7, 9, 3, 1};
        int rob = t.rob(n);
        System.out.println(rob);
    }
}
