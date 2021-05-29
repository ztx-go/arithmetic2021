package leetcode.top;

import entity.ListNode;

public class Test19 {

    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    // 进阶：你能尝试使用一趟扫描实现吗？
    // 另一种方法，先遍历得到长度，然后再从头遍历到删除节点前
    //  双指针方法，只用一趟扫描就能实现
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode slow = dump;
        ListNode fast = dump;
        while (n != 0) {
            if (fast.next == null) {
                return head;
            }
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        Test19 t = new Test19();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        ListNode listNode = t.removeNthFromEnd(node1, 2);
        System.out.println(listNode);
    }
}
