package leetcode.easy;

import entity.ListNode;

public class TwoZeroThreeRemove {
    public ListNode removeElements(ListNode head, int val) {
//        定义一个 哨兵节点，定义一个前节点指针，和当前节点指针
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel, cur = head;
//        如果当前节点不为空
        while (cur != null) {
//            当前节点的值=val，则前指针删除当前节点
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
//                否则，前指针指向当前节点，
                pre = cur;
            }
//            当前节点指针后移
            cur = cur.next;
        }
//        返回哨兵后的链节点
        return sentinel.next;
    }
}
