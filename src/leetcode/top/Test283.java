package leetcode.top;

import java.util.Arrays;

public class Test283 {
    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j + 1];
                    nums[j + 1] = 0;
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //    输入: [0,1,0,3,12]
        // 输出: [1,3,12,0,0]
        Test283 t = new Test283();
        int[] arr = {0, 0, 1};
        t.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
