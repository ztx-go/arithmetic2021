package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ThreeEightThreeRansom {
    public boolean canConstruct(String ransomNote, String magazine) {

        List<Character> mlist=new ArrayList<>();
        for(int i=0;i<magazine.length();i++){
            mlist.add(magazine.charAt(i));
        }
        for(int j=0;j<ransomNote.length();j++){
            if(mlist.contains(ransomNote.charAt(j))){
                mlist.remove((Character) ransomNote.charAt(j));
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ThreeEightThreeRansom t=new ThreeEightThreeRansom();
        boolean b = t.canConstruct("aa", "ba");
        System.out.println(b);
    }
}
//    定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串
//   ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，
//  返回 true ；否则返回 false  杂志字符串中的每个字符只能在赎金信字符串中使用一次。
//输入：ransomNote = "aa", magazine = "ab"
//        输出：false