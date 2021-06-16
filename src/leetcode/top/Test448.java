package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test448 {
    //给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n]
    // 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
    //进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。



    // 使用的set集合作为额外空间
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    //具体来说，遍历 nums，每遇到一个数 xx，就让  nums[x−1] 增加 nn。
    // 由于 nums 中所有数均在 [1,n] 中，增加以后，这些数必然大于n。最后我们遍历 nums，
    // 若nums[i] 未大于 nn，就说明没有遇到过数i+1。这样我们就找到了缺失的数字。
    //类似解法：把出现过的数作为索引,并把对应的值改为负数，如果谁是正数,这个数没有作为索引出现过
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;//遍历数组，把获取到的每一个数字当做索引，在对这个索引所指向的数进行操作
            nums[x] += n;//这里的操作时+n（类似解法中的操作是变成负数）
        }
        System.out.println(Arrays.toString(nums)+"==");
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {//再遍历每个索引，如果当前值没有变化，则说明这个索引对应的数字没有出现
                ret.add(i + 1);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        //    输入：nums = [4,3,2,7,8,2,3,1]
        // 输出：[5,6]
        Test448 t = new Test448();
        // int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] arr = {1,2,3,4,4};
        List<Integer> disappearedNumbers = t.findDisappearedNumbers2(arr);
        System.out.println(disappearedNumbers);
    }
}
