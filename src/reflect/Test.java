package reflect;

import leetcode.easy.OneTwoNumberSum;

public class Test {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("leetcode.easy.OneTwoNumberSum");
            System.out.println(aClass.getName()+","+aClass.getSimpleName());
            OneTwoNumberSum o = (OneTwoNumberSum)aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
