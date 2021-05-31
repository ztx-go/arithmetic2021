package leetcode.top;

public class Test198 {
    //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    // 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    // 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    // 输入：[1,2,3,1]
    // 输出：4
    // 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。 偷窃到的最高金额 = 1 + 3 = 4 。
    //使用动态规划来求解
    public int rob(int[] nums) {
        // 边界值的确定
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //数组存放偷对应房屋的最大钱数 确定前面两个数字
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //转移方程
            arr[i] = Math.max(arr[i - 2] + nums[i], arr[i - 1]);
        }
        return arr[nums.length - 1];

        //上述方法使用了数组存储结果。考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，
        // 因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
        //    int first = nums[0], second = Math.max(nums[0], nums[1]);
        //         for (int i = 2; i < length; i++) {
        //             int temp = second;
        //             second = Math.max(first + nums[i], second);
        //             first = temp;
        //         }
        //         return second;
        //
    }

    public static void main(String[] args) {
        Test198 t = new Test198();
        int[] arr = {2, 7, 9, 3, 1};
        int rob = t.rob(arr);
        System.out.println(rob);
    }
}
