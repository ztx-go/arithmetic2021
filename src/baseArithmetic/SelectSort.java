package baseArithmetic;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
//        选择排序：每次选择出最大或最小的一个数字，然后和这次排序的数字交换位置
        int[] array = new int[]{3, 9, 5, 7, 2, 8, 1};
//        一次循环：表示排序的次数
        for (int i = 0; i < array.length; i++) {
//            这一轮最小或最大的下标索引的初始
            int min = i;
//            和后续的进行对比选择，选择出这一轮最大或者最小的数字的下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
//            进行交换，将最大或者最小的数字放在最前面
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
