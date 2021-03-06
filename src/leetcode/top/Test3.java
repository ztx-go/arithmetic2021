package leetcode.top;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test3 {

//    3. 无重复字符的最长子串
//     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//     输入: s = "abcabcbb"
//     输出: 3
//     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    public int lengthOfLongestSubstring(String s) {

        //使用set集合暴力破解，一遍循环，记录每个字符的最大子串长度，然后选择出最大的来返回
        // 执行用时： 74 ms , 在所有 Java 提交中击败了 14.79%  的用户
        // 内存消耗：  39.1 MB  , 在所有 Java 提交中击败了 11.92%  的用户

        int max = 0;
        Set<Object> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int num = 0;
            int j = i;
            while (j < s.length() && set.add(s.charAt(j))) {
                num++;
                j++;
            }
            max = Math.max(max, num);
            set.clear();
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
    //    答案使用滑动窗口来解决问题,比自己写的优化了一些，感觉也差不太多

        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    //网友的滑动窗口解法（之后再看吧）
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);//获取最大长度
            map.put(s.charAt(end), end + 1);//存放入map，key和位置+1
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = " ";
        Test3 t = new Test3();
        int i = t.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
