package leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
    //    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    //使用回溯法：可以套用回溯法的公式
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    //我们可以只在序列仍然保持有效时才添加 '(' or ')'
    //我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {//这个左右括号数量需要传进来
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {//左括号数量小于最大对数时才能
            cur.append('(');//回溯公式，先添加
            backtrack(ans, cur, open + 1, close, max);//再递归
            cur.deleteCharAt(cur.length() - 1);//最后在删除
        }
        if (close < open) {//右括号小于最大对数时才行
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    public static void main(String[] args) {
        Test22 t=new Test22();
        List<String> strings = t.generateParenthesis(3);
        System.out.println(strings);
    }
}
