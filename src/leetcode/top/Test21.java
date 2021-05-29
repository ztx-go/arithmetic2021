package leetcode.top;

import entity.ListNode;

public class Test21 {
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    // 迭代法：
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode pre = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dum.next;
    }

    //递归法：终止条件：当两个链表都为空时，表示我们对链表已合并完成。
    //如何递归：我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        Test21 t = new Test21();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;

        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(0);
        node21.next = node22;
        node22.next = node23;

        ListNode listNode = t.mergeTwoLists(node1, node21);
        System.out.println(listNode);
    }
}
