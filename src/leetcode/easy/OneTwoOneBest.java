package leetcode.easy;

public class OneTwoOneBest {
    public int maxProfit(int[] prices) {
//        利润设置初始化，指向最低价格的指针
        int sum = -prices[0];
        int first = prices[0];
//        一次遍历，当前价格-当前最低价格=利润，如果利润比之前大，就替换
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - first;
            if (temp > sum) {
                sum = temp;
            }
//            若遇到更低的价格，则指向最低价格的指针移动，此时最大利润记录的还是之前最低
//            价格时的最大收益
            if (prices[i] < first) {
                first = prices[i];
            }
        }
        return sum > 0 ? sum : 0;
    }

    public static void main(String[] args) {
        OneTwoOneBest t = new OneTwoOneBest();
        int[] a = new int[]{7, 6, 5, 4, 3, 2, 1};
        int i = t.maxProfit(a);
        System.out.println(i);
    }
}
//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法
// 来计算你所能获取的最大利润。返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//输入：[7,1,5,3,6,4]
//        输出：5