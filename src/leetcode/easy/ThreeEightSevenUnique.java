package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeEightSevenUnique {
    //  超时
    public int firstUniqChar(String s) {
        if (s.length() == 1) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    temp++;
                }
            }
            if (temp == 1) {
                return i;
            }
        }
        return -1;
    }

//    两次for循环，使用hash表来存次数
    public int firstUniqChar2(String s) {
        if (s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ThreeEightSevenUnique t = new ThreeEightSevenUnique();
        int result = t.firstUniqChar("aadadead");
        System.out.println(result);
    }
}

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
