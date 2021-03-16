package leetcode.easy;

public class OneTwoTwoBest {
    public int maxProfit(int[] prices) {
        int length = prices.length;
//        注意这里，new 一个length长度的二维数组
        int[][] profix = new int[length][2];
//          第N天最大利润，手里没有股票和有股票，列出两个转移方程
        int sum = 0;
        profix[0][0] = 0;
        profix[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
//            第i天手上没有股票时的利润：前一天手上没有股票或前一天手上有又卖出赚钱
            profix[i][0] = Math.max(profix[i - 1][0], profix[i - 1][1] + prices[i]);
//            第i天手上有股票时的利润：前一天手上有股票或前一天手上没有时买入花钱
            profix[i][1] = Math.max(profix[i - 1][1], profix[i - 1][0] - prices[i]);
            sum = profix[i][0];
        }
        return sum;

    }

    public static void main(String[] args) {
        OneTwoTwoBest t=new OneTwoTwoBest();
        int[] a=new int[]{7,1,5,3,6,4};
        int i = t.maxProfit(a);
        System.out.println(i);
    }
}
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

