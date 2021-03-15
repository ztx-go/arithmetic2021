package leetcode.easy;

public class FiveEightLength {
    public int lengthOfLastWord(String s) {
//        记录字母的个数，遇到空格就结束计数
        int length = s.length();
        int sum = 0;
        for (int i = length - 1; i >= 0; i--) {
//            注意如果以空格结尾的时候
            if (!Character.isLetter(s.charAt(i)) && sum == 0) {
                continue;
            }
            if (Character.isLetter(s.charAt(i))) {
                sum++;
            } else {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        FiveEightLength f = new FiveEightLength();
        String s = "a bc";
        int i = f.lengthOfLastWord(s);
        System.out.println(i);
    }
}
// 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。
// 如果不存在最后一个单词，请返回 0 。
//单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

