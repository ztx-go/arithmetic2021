package leetcode.top;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Test20 {
    //    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
    public boolean isValid(String s) {
        //如果长度为0，直接返回true
        if (s.length() == 0) {
            return true;
        }
        //新建一个栈
        // Stack<Object> stack = new Stack<>();
        // 现在创建栈使用linkedList
        Deque<Object> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            //进栈条件
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                //防止从空栈里取
                // if (stack.empty()) {
                if (stack.isEmpty()) {
                    return false;
                }
                //取一个元素
                char pop = (char) stack.pop();
                char ss = s.charAt(i);
                //两个元素同时进行比较，出错就返回false
                if (!((pop == '(' && ss == ')') || (pop == '[' && ss == ']') || (pop == '{' && ss == '}'))) {
                    return false;
                }

            }
        }
        //最后必须保证栈空
        // if (stack.empty()) {
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Test20 t = new Test20();
        String s = "()[]{}";
        boolean valid = t.isValid(s);
        System.out.println(valid);
    }
}
