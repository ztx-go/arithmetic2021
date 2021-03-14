package leetcode.easy;

import java.util.Arrays;

public class TwoEightThreeMove {
    //  这个答案写复杂了
    public void moveZeroes(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0 && i < nums.length - sum) {
                for (int j = i; j < nums.length - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
//        使用两次遍历，第一次遍历将所有的非0值向前移动
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

//        第二次循环将后面的值都赋值为0
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes3(int[] nums) {
//        使用两个指针 当前元素!=0，就把其交换到左边，等于0的交换到右边
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        TwoEightThreeMove t = new TwoEightThreeMove();
//        int[] array = new int[]{0, 0, 1, 2};
        int[] array = new int[]{1, 0, 2, 3, 0, 4};
//        t.moveZeroes(array);
//        t.moveZeroes2(array);
        t.moveZeroes3(array);
        System.out.println(Arrays.toString(array));
    }
}
