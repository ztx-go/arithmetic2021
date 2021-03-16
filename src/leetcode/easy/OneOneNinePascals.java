package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class OneOneNinePascals {

    public List<Integer> generate(int numRows) {
//        和上一道一样的思路，动态规范，稍微修改一下就可以了
        numRows = numRows + 1;
        int[][] a = new int[numRows + 1][numRows + 1];
        List<Integer> b = new ArrayList<>();
        a[0][0] = 0;
        a[0][1] = 1;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
//                找出关系式，确定边界值
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                temp.add(a[i][j]);
            }
            if (i == numRows) {
                b = temp;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        OneOneNinePascals t = new OneOneNinePascals();
        List<Integer> generate = t.generate(6);
        System.out.println(generate);
    }
}
// 杨辉三角，只输出当前的