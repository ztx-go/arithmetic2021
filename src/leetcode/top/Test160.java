package leetcode.top;

import entity.ListNode;

public class Test160 {
    //给你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    // 图示两个链表在节点 c1 开始相交：
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                p1 = headB;//将p1重新定位到headB上
            }
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                p2= headA;//将p2重新定位到headA上
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        Test160 t = new Test160();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        ListNode intersectionNode = t.getIntersectionNode(node1, node6);
        System.out.println(intersectionNode);
    }
}
