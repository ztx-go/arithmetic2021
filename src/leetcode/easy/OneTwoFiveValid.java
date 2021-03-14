package leetcode.easy;

public class OneTwoFiveValid {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
//        需要新创建一个stringBuilder，不然revert会在原来的sb上进行
        StringBuilder sbre = new StringBuilder(sb);
        StringBuilder reverse = sbre.reverse();
        return reverse.toString().equals(sb.toString());
    }

    public static void main(String[] args) {
        boolean palindrome = OneTwoFiveValid.isPalindrome("A man, la plan, a canal: Panama");
        System.out.println(palindrome);
    }
}
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//输入: "A man, a plan, a canal: Panama"
//        输出: true