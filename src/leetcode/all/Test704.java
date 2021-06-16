package leetcode.all;

public class Test704 {
    //给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
    // 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        //  如果写的是while (left <= right) 就不需要下面的，如果是  while (left < right)就需要下面的
        // if (nums[left] == target) {
        //     return left;
        // }
        return -1;

    }

    public static void main(String[] args) {
        Test704 t = new Test704();
        //输入: nums = [-1,0,3,5,9,12], target = 9
        // 输出: 4
        // 解释: 9 出现在 nums 中并且下标为 4
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int search = t.search(arr, 2);
        System.out.println(search);
    }
}
