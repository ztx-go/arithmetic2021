package leetcode.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test49 {
    //    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();//变成字符数组
            Arrays.sort(array);//字符数组排序，当做key
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());//key对应的value为集合
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());//返回map所有的value形成的集合
    }

    public static void main(String[] args) {
        //输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
        // 输出:
        // [
        //   ["ate","eat","tea"],
        //   ["nat","tan"],
        //   ["bat"]
        // ]
        Test49 t = new Test49();
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = t.groupAnagrams(arr);
        System.out.println(lists);

    }
}
