package leetcode.easy;

import entity.ListNode;

public class TwoZeroSixRevese {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

//    反转一个单链表。
//    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL
}
