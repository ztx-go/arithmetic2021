package leetcode.easy;

import java.util.Stack;

public class OneZeroTwoOneRemove {
    public String removeOuterParentheses(String s) {

        int first = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
//        利用辅助栈进行原语的划分
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
//               栈空的时候说明原语化解了，进行去外面的括号 （subString 包含头不包含尾）
                String substring = s.substring(first + 1, i);
                sb.append(substring);
                first = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OneZeroTwoOneRemove t=new OneZeroTwoOneRemove();
        String s = t.removeOuterParentheses("(()())(())(()(()))");
        System.out.println(s);
    }
}
//有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 
//  代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
//  如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），
//   其中 A 和 B 都是非空有效括号字符串。 给出一个非空有效字符串 S，考虑将其进行原语化分解，
//   使得：S = P_1 + P_2 + ... + P_k，其中 P_i  是有效括号字符串原语。
//  对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。