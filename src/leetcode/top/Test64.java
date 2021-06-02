package leetcode.top;

public class Test64 {

    //给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    // 说明：每次只能向下或者向右移动一步。
    // 这道题本质上和62题是一样的，只不过这道题需要算每一步上的数字
    public int minPathSum(int[][] grid) {
        // 还是需要先进行边界值的判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] arr = new int[grid.length][grid[0].length];
        arr[0][0] = grid[0][0];//第一个值单独初始化
        for (int i = 1; i < grid.length; i++) {
            arr[i][0] = grid[i][0] + arr[i - 1][0];//之前路径的数字和+自身的数字
        }
        for (int j = 1; j < grid[0].length; j++) {
            arr[0][j] = grid[0][j] + arr[0][j - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                arr[i][j] = Math.min(arr[i][j - 1], arr[i - 1][j]) + grid[i][j];//获取之前方向的最小数字和，再加上自身的数字
            }
        }
        return arr[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        Test64 t = new Test64();
        //输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
        // 输出：7
        // 解释：因为路径 1→3→1→1→1 的总和最小。
        // int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        int i = t.minPathSum(arr);
        System.out.println(i);
    }
}
