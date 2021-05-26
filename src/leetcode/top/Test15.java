package leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class Test15 {
//    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
//    ？请你找出所有和为 0 且不重复的三元组。
// 注意：答案中不可以包含重复的三元组。

    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, nums, 0);
        // 回溯方法解出来的可能会有重复的，需要在去重，所以这个方法不能满足题目要求

        return result;

    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, int k) {

        if (path.size() == 3 && (path.get(0) + path.get(1) + path.get(2)) == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (path.size() >= 3) {
            return;
        }
        for (int i = k; i < nums.length; i++) {
            path.add(nums[i]);
            // System.out.println(path);
            dfs(result, path, nums, i + 1);// 传入i+1，保证取下个字符
            path.remove(path.size() - 1);
            // System.out.println(path);
        }
        //     输入：nums = [-1,0,1,2,-1,-4]
//     输出：[[-1,-1,2],[-1,0,1]]
    }

    public static void main(String[] args) {
        Test15 t = new Test15();
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = t.threeSum2(arr);
        System.out.println(lists.toString());
    }
}
