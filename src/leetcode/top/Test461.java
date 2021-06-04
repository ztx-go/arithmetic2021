package leetcode.top;

public class Test461 {
    //两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
    // 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。

    // 求二进制不同的位置的数量，先异或，然后在统计1的个数
    //我们使用异或运算，记为 ⊕，当且仅当输入位不同时输出为 11
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);//内置位计数功能
    }

    //自己动手计数
    public int hammingDistance2(int x, int y) {
        int s = x ^ y;//x和y异或的结果，异或：相同为0，不同为1
        int ret = 0;
        while (s != 0) {
            ret = ret + s & 1;// s和1进行与运算，都为1的时候返回1，其中一个为0则返回0
            s = s >> 1;//右移一位，可以去掉最低位的数字
        }
        return 1;
    }

    public static void main(String[] args) {
        //输入：x = 1, y = 4
        // 输出：2
        // 解释：
        // 1   (0 0 0 1)
        // 4   (0 1 0 0)
        //        ↑   ↑
        // 上面的箭头指出了对应二进制位不同的位置。

        Test461 t = new Test461();
        int i = t.hammingDistance(1, 4);
        System.out.println(i);

    }
}
