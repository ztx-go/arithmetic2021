package leetcode.top;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class Test75 {
    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    // 此题中，我们使用整数 0,1 和 2 分别表示红色、白色和蓝色。

    //方法一：两次for循环是最简单的，最容易理解
    public void sortColors(int[] nums) {

        int n = nums.length;
        int ptr = 0;
        //把所有的0移到最前面，同时记录最后一个0后面的元素索引
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        //从刚才记录的索引开始，将剩余的1移到0后面
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    public static void main(String[] args) {
//输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]
        Test75 t = new Test75();
        int[] arr = {2, 0, 2, 1, 1, 0};
        t.sortColors(arr);
        System.out.println(arr);
    }
}
