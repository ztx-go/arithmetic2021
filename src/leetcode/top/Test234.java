package leetcode.top;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test234 {
    //请判断一个链表是否为回文链表。
    //简单方法：将链表的值全部复制到一个数组中，然后判断这个数组是否是回文数组
    public boolean isPalindrome2(ListNode head) {
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


    //时间O(n)，空间O(1)的算法，分成两个链，然后反转一个，判断是否回文，在将其反转回来
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
