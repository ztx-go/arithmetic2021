package leetcode.easy;

import java.util.*;

public class SixEightTwoBaseBall {
    public int calPoints(String[] ops) {

//        java 的栈和队列的数据结构实现
        Deque deque =  new LinkedList();
        Queue queue=new LinkedList();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if ("+".equals(ops[i])) {
                Integer pop = stack.pop();
                Integer peek = stack.peek();
                stack.push(pop);
                stack.push(pop + peek);
            } else if ("D".equals(ops[i])) {
                Integer peek = stack.peek();
                stack.push(peek * 2);

            } else if ("C".equals(ops[i])) {
                stack.pop();

            } else {
                stack.push(Integer.parseInt(ops[i]));

            }
        }
        Iterator<Integer> iterator = stack.iterator();
        int sum = 0;
//        迭代器
//        while (iterator.hasNext()) {
//            sum = sum + stack.pop();
//        }

//        for循环
        for (Integer i : stack) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        SixEightTwoBaseBall tt = new SixEightTwoBaseBall();
        String[] s = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
//        String[] s=new String[]{"5","2","C","D","+"};
        int i = tt.calPoints(s);
        System.out.println(i);
    }
}
//你现在是一场采用特殊赛制棒球比赛的记录员。
// 这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。