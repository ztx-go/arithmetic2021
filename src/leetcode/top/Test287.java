package leetcode.top;

public class Test287 {
    //    给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到n之间（包括 1 和 n），可知至少存在一个重复的整数。
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
//

    // 首先明确前提，整数的数组 nums 中的数字范围是 [1,n]。
    //我们先设置慢指针 slow 和快指针 fast ，慢指针每次走一步，快指针每次走两步，
    // 根据「Floyd 判圈算法」两个指针在有环的情况下一定会相遇，此时我们再将 slow 放置起点 0，
    // 两个指针每次同时移动一步，相遇的点就是答案。

    // 将这个题目给的特殊的数组当作一个链表来看，数组的下标就是指向元素的指针，把数组的元素也看作指针。
    // 如 0 是指针，指向 nums[0]，而 nums[0] 也是指针，指向 nums[nums[0]].
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
//    输入：nums = [1,3,4,2,2]
// 输出：2
        Test287 t = new Test287();
        int[] arr = {1, 3, 4, 2, 2};
        int duplicate = t.findDuplicate(arr);
        System.out.println(duplicate);
    }

}
