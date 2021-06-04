package leetcode.top;

import java.util.Arrays;

public class Test338 {
    //    338. 比特位计数
//    给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

    //利用 Brian Kernighan 算法，可以在一定程度上进一步提升计算速度。
    //  Brian Kernighan 算法的原理是：对于任意整数 xx，令 x=x&(x-1)，
    // 该运算将x 的二进制表示的最后一个1变成0。因此，对x 重复该操作，直到x变成0，则操作次数即为x 的「一比特数」。
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    public static void main(String[] args) {
        //    输入: 5
        // 输出: [0,1,1,2,1,2]
        Test338 t = new Test338();
        int[] ints = t.countBits(5);
        System.out.println(Arrays.toString(ints));
    }
}
