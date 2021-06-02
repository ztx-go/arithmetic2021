package leetcode.top;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Test739 {
    //请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
    // 如果气温在这之后都不会升高，请在该位置用 0 来代替。

    // 暴力解法：使用两个for循环
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }

        }
        return result;
    }

    //使用栈来解决：维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Arrays.fill(ans, 0);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length - 1; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                Integer prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Test739 t = new Test739();
        //例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
        // 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        // int[] ints = t.dailyTemperatures(arr);
        int[] ints = t.dailyTemperatures2(arr);
        System.out.println(Arrays.toString(ints));
    }
}
