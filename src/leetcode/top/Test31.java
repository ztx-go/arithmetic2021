package leetcode.top;

import java.util.Arrays;

public class Test31 {
    //    实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
// 必须 原地 修改，只允许使用额外常数空间。

    //算法思路
    //具体地，我们这样描述该算法，对于长度为 nn 的排列 aa：
    // 首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
    // 如果找到了顺序对，那么在区间[i+1,n)中从后向前查找第一个元素j满足 a[i] < a[j]。这样「较大数」即为 a[j]。
    // 交换 a[i]与a[j]，此时可以证明区间 [i+1,n)必为降序。我们可以直接使用双指针反转区间 [i+1,n)使其变为升序，
    // 而无需对该区间进行排序。
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            //在区间[i+1,n)中从后向前查找第一个元素j满足 a[i] < a[j]
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //交换 a[i]与a[j]
            swap(nums, i, j);
        }
        //反转区间 [i+1,n)使其变为升序
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        //    输入：nums = [1,2,3]
        // 输出：[1,3,2]
        Test31 t = new Test31();
        int[] arr = {1, 2, 3};
        t.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
