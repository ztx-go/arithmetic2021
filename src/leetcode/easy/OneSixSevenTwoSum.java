package leetcode.easy;

public class OneSixSevenTwoSum {
    public int[] twoSum(int[] numbers, int target) {
//       思路：最后和最前面的数相加，若大了，后面的指针前移，小了就前面的指针后移
       int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            }
        }
        return new int[]{0};
    }
}
//  给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，
//  所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素
