package leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class Test78 {
    //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    // 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dp(result, path, nums, 0);
        return result;
    }

    private void dp(List<List<Integer>> result, List<Integer> path, int[] nums, int i) {
        if (i == nums.length) {//这里的i用来记录递归的次数？
            result.add(new ArrayList<>(path));// 记录答案
            return;
        }
        // 考虑选择当前位置
        path.add(nums[i]);
        dp(result, path, nums, i + 1);
        path.remove(path.size() - 1);
        // 考虑不选择当前位置  （这道题比之前的回溯多了这一步）
        dp(result, path, nums, i + 1);
    }

    public static void main(String[] args) {
        Test78 t = new Test78();
        // 输入：nums = [1,2,3]
        // 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = t.subsets(arr);
        System.out.println(subsets);
    }
}
