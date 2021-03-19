package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoZeroTwoHappy {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = this.getTotal(n);
        }
        return n == 1;

    }

    public int getTotal(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            n = n / 10;
            sum = sum + i * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        TwoZeroTwoHappy t = new TwoZeroTwoHappy();
        boolean happy = t.isHappy(19);
        System.out.println(happy);
    }
}
