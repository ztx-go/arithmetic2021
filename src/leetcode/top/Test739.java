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
    //元素都是下标，括号内的数字表示下标在温度列表中对应的温度。
    // 当i=0 时，单调栈为空，因此将0进栈。
    //  stack=[0(73)]
    //  ans=[0,0,0,0,0,0,0,0]
    // 当i=1 时，由于74大于73，因此移除栈顶元素0，赋值 ans[0]:=1-0 ，将1进栈。
    // stack=[1(74)]
    //  ans=[1,0,0,0,0,0,0,0]
    // 当 i=2 时，由于75大于74 ，因此移除栈顶元素1，赋值ans[1]:=2−1，将2进栈。
    // stack=[2(75)]
    // ans=[1,1,0,0,0,0,0,0]
    //  i=3 时，由于71小于75，因此将3 进栈。
    //  stack=[2(75),3(71)]
    //  ans=[1,1,0,0,0,0,0,0]
    // 当i=4 时，由于69 小于71，因此将4 进栈。
    // stack=[2(75),3(71),4(69)]
    // ans=[1,1,0,0,0,0,0,0]
    // 当 i=5 时，由于 72 大于69和71，因此依次移除栈顶元素4 和3，赋值ans[4]:=5−4 和ans[3]:=5−3，将5进栈。
    //  stack=[2(75),5(72)]
    //  ans=[1,1,0,2,1,0,0,0]
    // 当 i=6 时，由于 76 大于72 和75，因此依次移除栈顶元素5和2，赋值ans[5]:=6−5 和ans[2]:=6−2，将6进栈。
    // stack=[6(76)]
    // ans=[1,1,4,2,1,1,0,0]
    // 当 i=7i=7 时，由于 7373 小于 7676，因此将 77 进栈。
    // stack=[6(76),7(73)]
    // ans=[1,1,4,2,1,1,0,0]

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Arrays.fill(ans, 0);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length - 1; i++) {
            int temperature = temperatures[i];//获取当前的温度
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {//如果栈不为空，且当前温度，大于栈顶的温度
                Integer prevIndex = stack.pop();//出栈，找到了这个下标后面的第一个最高温度
                ans[prevIndex] = i - prevIndex;//获取差值
            }
            stack.push(i);//下标（索引进栈）
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
