package leetcode.top;

public class Test11 {

    public int maxArea(int[] height) {
        //  使用双指针法
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    //这个解法超出了时间的限制
    public int maxArea1(int[] height) {
        //给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两
        // 个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        // 说明：你不能倾斜容器
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = test11.maxArea(arr);
        System.out.println(i);
    }
}
