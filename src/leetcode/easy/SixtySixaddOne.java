package leetcode.easy;

import java.util.Arrays;

public class SixtySixaddOne {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例 1
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * 示例 2：
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * 示例 3：
     * 输入：digits = [0]
     * 输出：[1]
     */
    public static void main(String[] args) {
        int[] array = new int[]{9, 9, 9};
        int[] ints = addOne(array);
        int[] ints2 = addOne2(array);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] addOne(int[] array) {
//        从后向前进行循环，注意这里i>=0；为0的时候判断第一位
        for (int i = array.length - 1; i >= 0; i--) {
//            最后一位+1，判断是否为10，为10就置为0再循环，不为10就可以直接返回加一后的结果
            int temp = array[i] + 1;
            if (temp == 10) {
                array[i] = 0;
            } else {
                array[i] = temp;
                return array;
            }
        }
//        循环结束后，所有位都成了0，新建一个数组，第一位为1
        array = new int[array.length + 1];
        array[0] = 1;
        return array;
    }

    //    答案：https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
    private static int[] addOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}

