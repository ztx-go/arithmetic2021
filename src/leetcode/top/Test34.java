package leetcode.top;

import java.util.Arrays;

public class Test34 {
    //    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length - 1;
        while (start < nums.length && nums[start] < target) {
            start++;
        }
        while (end > 0 && nums[end] > target) {
            end--;
        }
        if (start <= end && nums[start] == target && nums[end] == target) {
            return new int[]{start, end};
        }
        return new int[]{-1, -1};
    }

    //输入：nums = [5,7,7,8,8,10], target = 8
    // 输出：[3,4]
    public static void main(String[] args) {
        Test34 t = new Test34();
        // int[] arr = {5, 7, 7, 8, 8, 10};
        // int target = 8;
        int[] arr = {1, 2};
        int target = 0;
        int[] ints = t.searchRange(arr, target);
        System.out.println(Arrays.toString(ints));
    }
}
