package baseArithmetic;

import java.util.Arrays;

public class BobbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 6, 9, 5, 3};
        BobbleSort b = new BobbleSort();
        // int[] result = b.bobble1(array);
        // System.out.println("=======" + Arrays.toString(result));

        int[] ints = b.bobble2(array);
        System.out.println(ints);
    }

    // 冒泡，最大的冒到后面
    public int[] bobble1(int[] array) {

//    冒泡排序:一次排序通过相邻的两个数字比较大小，然后进行交换，最大或者最小的数字会冒泡到最后
        int length = array.length;
//        第一层循环表示要执行多少此排序，i<length表示每个都排，i<length-1表示最后一个可以不用排
        for (int i = 0; i < length - 1; i++) {
//            内层的循环表示 未排序的子对列的冒泡排序 注意j<length-1-i 要多减去1
//            因为本身要和他之后的一个比较 防止空指针
            Boolean flag = false;
            for (int j = 0; j < length - 1 - i; j++) {
//                冒泡的过程
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(array));
            if (!flag) {
                break;
            }
        }
        return array;
    }

    // 最小的冒到前面
    public int[] bobble2(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+ 1; j < length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
