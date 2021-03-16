package leetcode.easy;

import java.util.*;

public class OneOneEigthPascals {
//  动态规划去做这个题
    public List<List<Integer>> generate(int numRows) {
        int[][] a = new int[numRows+1][numRows+1];
        List<List<Integer>> b = new ArrayList<>();
        a[0][0] = 0;
        a[0][1] = 1;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
//                找出关系式，确定边界值
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                temp.add(a[i][j]);
            }
            b.add(temp);
        }
        return b;
    }

    public static void main(String[] args) {
        OneOneEigthPascals t=new OneOneEigthPascals();
        List<List<Integer>> generate = t.generate(4);
        System.out.println(generate);
    }
}
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。