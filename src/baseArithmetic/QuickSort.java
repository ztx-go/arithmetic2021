package baseArithmetic;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 7, 2, 9, 5, 1};
//        quickSort(array, 0, array.length - 1);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int i, int j) {
        if (i >= j) {
            return;
        }
        int position = partition(array, i, j);
        quickSort(array, 0, position - 1);
        quickSort(array, position + 1, j);
    }

    private static int partition(int[] array, int i, int j) {
//        取第一个待归位元素
        int temp = array[i];
//        当i<j时，一直进行循环，完成temp的归位
        while (i < j) {
//        当i<j 右边找到一个比待归位元素temp小的数时停止，否则，右边左移
            while (i < j && temp < array[j]) {
                j--;
            }
//            找到，赋值给左边的空位
            array[i] = array[j];
//            当i<j  左边找一个比待归位元素temp大的数 时停止，否则，左移
            while (i < j && temp > array[i]) {
                i++;
            }
//            找到，赋值给右边的空位
            array[j] = array[i];
        }
//      当左右指针相遇时，将带归位的数字temp赋值给这个位置，这个位置有序
        array[i] = temp;
        System.out.println(Arrays.toString(array));
//        返回这个位置，在让左右两边的数组递归排序
        return i;
    }
}
