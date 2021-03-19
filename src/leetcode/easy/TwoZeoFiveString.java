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
