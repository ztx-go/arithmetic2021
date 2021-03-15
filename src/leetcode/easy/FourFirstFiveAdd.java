package leetcode.easy;

public class FourFirstFiveAdd {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
//        注意这个循环条件：i>=0 ||j>=0||add!=0
        while (i >= 0 || j >= 0 || add != 0) {
//            只有i和j大于等于0时，才取值，取值为chatAt(i)-'0'
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();

    }

//    public String addStrings2(String num1, String num2) {
//        int m = num1.length() - 1, n = num2.length() - 1, add = 0;
//        StringBuilder sb = new StringBuilder();
//        while (m >= 0 || n >= 0 || add >= 0) {
//            int a = m >= 0 ? num1.charAt(m) - '0' : 0;
//            int b = n >= 0 ? num2.charAt(n) - '0' : 0;
//            int i = a + b + add;
//            sb.append(i % 10);
//            add = i / 10;
//            m--;
//            n--;
//        }
//        return sb.reverse().toString();
//    }

    public static void main(String[] args) {
        FourFirstFiveAdd t = new FourFirstFiveAdd();
        String s = t.addStrings("123", "123");
        System.out.println(s);
    }
}
