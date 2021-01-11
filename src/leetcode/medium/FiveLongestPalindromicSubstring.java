package leetcode.medium;

import com.sun.deploy.util.StringUtils;

public class FiveLongestPalindromicSubstring {
    public static void main(String[] args) {
//        给你一个字符串 s，找到 s 中最长的回文子串。
//        示例 1：
//        输入：s = "babad"
//        输出："bab"
//        解释："aba" 同样是符合题意的答案。

        String result = longestPalindrome("abadb");
        System.out.println(result);

    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    private static boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
