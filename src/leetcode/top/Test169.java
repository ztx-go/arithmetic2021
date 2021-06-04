package leetcode.top;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test169 {
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
    // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    //最简单粗暴的方法：排序后取中间的数字，一定是排好的
    public int majorityElement(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length / 2];
    }

    // 使用hash表的方法：
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // 获取map数组中最大value的key
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        return index;
    }

    public static void main(String[] args) {
        // 输入：[2,2,1,1,1,2,2]
        // 输出：2
        Test169 t = new Test169();
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        // int i = t.majorityElement(arr);
        int i = t.majorityElement2(arr);
        System.out.println(i);
    }
}
