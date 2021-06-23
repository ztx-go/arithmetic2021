package leetcode.top;

import java.util.Arrays;

public class Test283 {
    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j + 1];
                    nums[j + 1] = 0;
                    nums[j] = temp;
                }
            }
        }
    }

    //两次遍历：两次遍历方法
    public void moveZeroes2(int[] nums) {
        if(nums==null){
            return;
        }
        int j=0;
        //一次遍历将所有非0值放到前面
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        //二次遍历将后面的数全部补成0
        for(int i=j;i<nums.length;i++){
            nums[i]=0;
        }
    }

    //一次遍历：这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，
    // 大于x的元素放到其右边。这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
    public void moveZeroes3(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        //    输入: [0,1,0,3,12]
        // 输出: [1,3,12,0,0]
        Test283 t = new Test283();
        int[] arr = {0, 0, 1};
        t.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
