package leetcode.top;

public class Test121 {
    // 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    // 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    // 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    // 输入：[7,1,5,3,6,4]
    // 输出：5
    // 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    // 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

    // 使用动态规划的思想的做法
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] arr = new int[prices.length];//转移方程数组，获取这天以及之前的最小值
        arr[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            arr[i] = Math.min(arr[i - 1], prices[i]);//转移方程
            max = Math.max(max, prices[i] - arr[i - 1]);//获取最大利润
        }
        return max;
    }

    //一次遍历法
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;//最小价钱初始化为一个最大值，方便后面比较的时候
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];//比较选出最小价钱
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;//当前的最大利润如果大于之前的，则替换
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        Test121 t = new Test121();
        int[] arr = {7, 1, 5, 3, 6, 4};
        int i = t.maxProfit(arr);
        System.out.println(i);

    }
}
