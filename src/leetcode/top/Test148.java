package leetcode.top;

import entity.ListNode;

public class Test148 {
    // 给你链表的头结点head ，请将其按 升序 排列并返回 排序后的链表 。

    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        //空直接返回
        if (head == null) {
            return head;
        }
        //只有一个节点的时候，将next置空
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 快慢指针查找出中间节点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sort(head, mid);//迭代获取左右两个子链
        ListNode list2 = sort(mid, tail);
        ListNode sorted = merge(list1, list2);//进行合并排好的两个左右子链
        return sorted;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);//定义一个哑结点
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        }
        if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Test148 t = new Test148();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        ListNode listNode = t.sortList(node1);
        System.out.println(listNode);
    }
}
