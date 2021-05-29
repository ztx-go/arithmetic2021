package leetcode.top;

import entity.ListNode;

public class Test141 {
    //给定一个链表，判断链表中是否有环。
    // 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来
    // 表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，
    // 仅仅是为了标识链表的实际情况。
    // 如果链表中存在环，则返回 true 。 否则，返回 false 。
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test141 t = new Test141();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // node4.next = node2;
        boolean b = t.hasCycle(node1);
        System.out.println(b);
    }
}
