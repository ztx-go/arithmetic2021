package leetcode.top;

import entity.ListNode;

public class Test206 {

    // 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    //输入：head = [1,2,3,4,5]
    // 输出：[5,4,3,2,1]

    //迭代法：
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {//边界条件
            return head;
        }
        ListNode pre = head;//第一个节点
        ListNode after = head.next;//第二个节点
        pre.next = null;//需要把第一个节点的next指向null，没有这一步的话会出现一个循环指针的问题
        while (after != null) {
            ListNode temp = after.next;//取出下一个，临时节点
            after.next = pre;//反转
            pre = after;//前一个指针移到当前位置
            after = temp;//指向当前位置的指针向前移动
        }
        return pre;
    }

    //递归法：
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);//newHead是新的反转链的头结点
        head.next.next = head;//假设链表的其余部分已经被反转，现在应该如何反转它前面的部分？
        head.next = null;//需要注意的是n1 的下一个节点必须指向∅。如果忽略了这一点，链表中可能会产生环。
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;

        Test206 t = new Test206();
        // ListNode listNode = t.reverseList(node1);
        // System.out.println(listNode);

        ListNode listNode1 = t.reverseList2(node1);
        System.out.println(listNode1);
    }

}
