package leetcode.top;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class Test75 {
    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    // 此题中，我们使用整数 0,1 和 2 分别表示红色、白色和蓝色。



    //方法一：快排
    public void sortColors(int[] nums) {
        quick2(nums, 0, nums.length - 1);
    }

    public void quick2(int[] arr, int begin, int end) {
        if (begin > end) {
            return;
        }
        int partion = partion(arr, begin, end);
        quick2(arr, begin, partion - 1);
        quick2(arr, partion + 1, end);
    }

    private int partion(int[] arr, int begin, int end) {
        int temp = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] > temp) {
                end--;
            }
            arr[begin] = arr[end];
            while (begin < end && arr[begin] <= temp) {
                begin++;
            }
            arr[end] = arr[begin];
        }
        arr[begin] = temp;
        System.out.println(Arrays.toString(arr));
        return begin;
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
