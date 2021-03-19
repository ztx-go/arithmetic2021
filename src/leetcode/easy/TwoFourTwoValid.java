package leetcode.easy;

import java.util.*;

public class TwoFourTwoValid {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
//            第一个字符串进行map的加操作
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
//            第二个字符串进行map的减操作
            map1.put(t.charAt(i), map1.getOrDefault(s.charAt(i), 0) - 1);
            if (map1.get(t.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
//        对s和t变成字符数组，进行排序，然后再比较是否相同
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
//        使用Arrays 工具类
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }

    public static void main(String[] args) {
        TwoFourTwoValid t = new TwoFourTwoValid();
        boolean anagram = t.isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }
}
// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
// 输入: s = "anagram", t = "nagaram"
// 输出: true

