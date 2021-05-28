package leetcode.top;

public class Test647 {
    // 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
    // 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
    // 输入："abc"
    // 输出：3
    // 解释：三个回文子串: "a", "b", "c"

    // 使用暴力解法求解，枚举出所有的子串，然后判断是否是回文，时间负责度O（n3）,效率低下
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            sum++;
            for (int j = i + 1; j < s.length(); j++) {
                if (isCount(s, i, j)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean isCount(String s, int i, int j) {
        if (i > j) {
            return false;
        }
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Test647 t = new Test647();
        String s = "abaaba";
        //4 a b a aba
        int i = t.countSubstrings(s);
        System.out.println(i);
    }
}
