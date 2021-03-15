package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeFourFiveReverse {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;

        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        list.add('A');
        list.add('E');
        list.add('I');
        list.add('O');
        list.add('U');
        while (i < j)
        {
//            两个都是元音的情况
            if (list.contains(chars[i]) && list.contains(chars[j])) {
                Character temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
//            左边不是
            if (!list.contains(chars[i])) {
                i++;
            }
//            右边不是
            if (!list.contains(chars[j])) {
                j--;
            }

        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ThreeFourFiveReverse t = new ThreeFourFiveReverse();
        String result = t.reverseVowels("leetcode");
        System.out.println(result);

    }
}
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。