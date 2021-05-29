package leetcode.top;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        int length = 0;
        while (head != null) {
            arr.add(head.val);
            head = head.next;
            length++;
        }
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            if(arr.get(i)!=arr.get(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test234 t = new Test234();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean palindrome = t.isPalindrome(node1);
        System.out.println(palindrome);
    }
}
