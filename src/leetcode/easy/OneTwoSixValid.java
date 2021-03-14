package leetcode.easy;

public class OneTwoSixValid {

    public boolean isPalindrome(String s) {
        
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 0) {
            return true;
        }
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            if (chars[i] == chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneTwoSixValid s = new OneTwoSixValid();
        boolean result = s.isPalindrome("a");
        System.out.println(result);
    }
//    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//说明：本题中，我们将空字符串定义为有效的回文串。
}
