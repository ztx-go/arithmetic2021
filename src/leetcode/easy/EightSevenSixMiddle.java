package leetcode.easy;

import entity.ListNode;

public class EightSevenSixMiddle {
    //  这里是单指针法，还可以使用双指针法，慢指针走一步，快指针走两步
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        int count = 0;
        while (first != null) {
            first = first.next;
            count++;
        }
        int med = 0;
        while (med < count / 2) {
            second = second.next;
            med++;
        }
        return second;
    }
}
// 链表的中间结点
//给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//        如果有两个中间结点，则返回第二个中间结点。
