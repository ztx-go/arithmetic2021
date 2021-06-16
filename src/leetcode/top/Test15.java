package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test15 {
//    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
//    ？请你找出所有和为 0 且不重复的三元组。
// 注意：答案中不可以包含重复的三元组。

    // 官方答案，排序+双指针  时间复杂度：O(N^2)，空间复杂度：O(\log N)
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);//先进行排序
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同（为了防止出现重复）
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧  nums[second] + nums[third] > target说明c大了，需要左移
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    //=================
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
        // List<List<Integer>> lists = t.threeSum2(arr);
        List<List<Integer>> lists = t.threeSum(arr);
        System.out.println(lists.toString());
    }
}
