package leetcode.top;

public class Test62 {

    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    // 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    // 问总共有多少条不同的路径？
    // 动态规划，难点在于列出转移方程
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            arr[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        return arr[m - 1][n - 1];
    }

    public static void main(String[] args) {
        //输入：m = 3, n = 7
        // 输出：28
        Test62 t = new Test62();
        int i = t.uniquePaths(3, 7);
        System.out.println(i);
    }
}
