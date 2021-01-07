package baseArithmetic;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 7, 2, 9, 5, 1};
//        插入排序：类似插入手牌，改变位置，找到最合适的插入
//        从下标为1的开始插入，直到最后一个
        for (int i = 1; i < array.length; i++) {
//            获取待插入数字，且j为已有序的数组的最后一个下标
            int temp = array[i];
            int j = i - 1;
//            循环，当最后一个下标大于或等于0，且此下标的数字大于待插入数字时，
//            后移，此时j下标后面的位置为可插入位置（这里只使用j，不用i，防止搞混淆）
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
//            将待插入数字插入到 j后面的可插入位置
            array[j + 1] = temp;
            System.out.println(Arrays.toString(array));
        }
    }
}
