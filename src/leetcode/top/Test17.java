package leetcode.top;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test17 {
    //    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    // 注意几个参数，结果集，map集合，字符串，索引位置，路径集合
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {//索引为长度时，可以存入结果集中
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);//获取索引字符
            String letters = phoneMap.get(digit);//通过map获取对应的字符串
            int lettersCount = letters.length();//字符串长度
            for (int i = 0; i < lettersCount; i++) {//循环去回溯字符串中的每个字符
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);//注意索引+1
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        Test17 t = new Test17();
        //输入：digits = "23"
        // 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        String s = "23";
        List<String> strings = t.letterCombinations(s);
        System.out.println(strings);
    }
}
