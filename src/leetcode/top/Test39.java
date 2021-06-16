package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test39 {
    // 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    // candidates 中的数字可以无限制重复被选取。
    // 说明：
    // 所有数字（包括 target）都是正整数。
    // 解集不能包含重复的组合。
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(result, path, candidates, target,0);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> path, int[] candidates, int target,int start) {
        int sum = 0;
        for (int number : path) {
            sum = sum + number;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {//如果i=0开始，就会有重复的，i=start 就不会有重复的结果
            path.add(candidates[i]);
            backtrace(result, path, candidates, target,i);//不重复是指结果集不重复，这里传i，可以重复取值
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        //    输入：candidates = [2,3,6,7], target = 7,
        // 所求解集为：
        // [
        //   [7],
        //   [2,2,3]
        // ]
        Test39 t = new Test39();
        // int[] arr = {2, 3, 6, 7};
        // int target = 7;
        int[] arr = {2, 3, 8};
        int target = 8;
        List<List<Integer>> lists = t.combinationSum(arr, target);
        System.out.println(lists);

    }
}
