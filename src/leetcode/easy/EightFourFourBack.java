package leetcode.easy;

import java.util.Stack;

public class EightFourFourBack {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#' && !stack1.isEmpty()) {
                stack1.pop();
            } else if (S.charAt(i) != '#') {
                stack1.push(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#' && !stack2.isEmpty()) {
                stack2.pop();
            } else if (T.charAt(i) != '#') {
                stack2.push(T.charAt(i));
            }
        }
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() == stack2.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "a#c";
        String s2 = "b";
        EightFourFourBack t = new EightFourFourBack();
        boolean b = t.backspaceCompare(s1, s2);
        System.out.println(b);
    }
}
