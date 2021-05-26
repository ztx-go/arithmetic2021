package leetcode.top;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public int[] twoSum(int[] nums, int target) {
        // 1. 两数之和
        // 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target
        // 的那 两个 整数，并返回它们的数组下标。
        // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
        // 你可以按任意顺序返回答案。


        for (int i = 0; i < nums.length - 1; i++) {
            int other = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (other == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        Test1 test1 = new Test1();
        int[] ints = test1.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = test1.twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
    }

}
