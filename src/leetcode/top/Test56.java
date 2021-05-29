package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test56 {
    //以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，
    // 并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
    // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    // 输出：[[1,6],[8,10],[15,18]]
    // 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //安装左边的端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        //存放结果的list
        List<int[]> merged = new ArrayList<int[]>();

        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            //如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合
            //我们可以直接将这个区间加入数组 merged 的末尾；
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {//merged为空的时候加入第一个区间
                merged.add(new int[]{L, R});
            } else {
                //否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);//可以直接修改数组的元素
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Test56 t = new Test56();
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = t.merge(arr);
        System.out.println(merge);

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
        list.add(new int[]{2});
        list.add(new int[]{3});

        list.get(2)[0] = 4;//这里能够直接进行修改
        System.out.println(list);//数组元素为1，2，4
    }
}
