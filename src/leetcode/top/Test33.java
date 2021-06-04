package leetcode.top;

public class Test33 {

    //整数数组 nums 按升序排列，数组中的值 互不相同 。
    // 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
    // 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    // 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
    // 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。

    //使用二分法进行查找
    public int search(int[] nums, int target) {
        //边界值的判断
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        //将数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;//获取中间位置
            if (nums[mid] == target) {//循环结束条件，判断nums[mid]是否等于target
                return mid;
            }
            if (nums[0] <= nums[mid]) {//左边有序
                if (nums[0] <= target && target < nums[mid]) {//target在0-mid区间时，缩小范围
                    r = mid - 1;
                } else {
                    l = mid + 1;//target不在这个区间
                }
            } else {//右边有序
                if (nums[mid] < target && target <= nums[n - 1]) {//target在mid-length区间，缩小范围
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
