package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class OneTwoNumberSum {
//    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 
//    两个 整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中
//    同一个元素不能使用两遍。你可以按任意顺序返回答案。
//    输入：nums = [2,7,11,15], target = 9
//    输出：[0,1]
//    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 15};
        int target = 22;
        int[] result = twoNumberSum(array, target);
        System.out.println(Arrays.toString(result));
        int[] result2 = twoNumberSum2(array, target);
        System.out.println(Arrays.toString(result2));
    }

    //  暴力枚举法：
    private static int[] twoNumberSum(int[] array, int target) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //    哈希表法：
    private static int[] twoNumberSum2(int[] array, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(target - array[i])) {
                return new int[]{hashMap.get(target - array[i]), i};
            }
            hashMap.put(array[i], i);
        }
        return new int[0];
    }
}
