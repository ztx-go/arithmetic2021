package leetcode.easy;

import java.util.Arrays;

public class EightEightMerge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//         1.简单方法，先复制到一个数组中，再进行排序
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);

//        下面的方法是复杂版，双指针，从后往前（还可以从前往后）
        if (nums2.length == 0) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int len = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[len] = nums2[j];
                j--;
            } else {
                nums1[len] = nums1[i];
                i--;
            }
            len--;
        }
        while (j >= 0) {
            nums1[len] = nums2[j];
            j--;
            len--;
        }
    }
}

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样
//它就有足够的空间保存来自 nums2 的元素
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        输出：[1,2,2,3,5,6]