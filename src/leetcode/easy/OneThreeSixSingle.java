package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OneThreeSixSingle {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
