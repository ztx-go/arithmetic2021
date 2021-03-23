package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoZeoFiveString {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
//        两个map，分别维护a-》b的映射和b-》a的映射
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
            }
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            }
            if (!map1.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            }
            if (!map2.get(t.charAt(i)).equals(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TwoZeoFiveString t = new TwoZeoFiveString();
        boolean result = t.isIsomorphic("egg", "acd");
        System.out.println(result);
    }
}
// 同构字符串：
//给定两个字符串 s 和 t，判断它们是否是同构的。
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到
// 同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//输入：s = "egg", t = "add"
//        输出：true

//输入：s = "foo", t = "bar"
//        输出：false