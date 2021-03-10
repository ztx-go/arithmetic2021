package leetcode.medium;

import entity.ListNode;

public class TenNineRemove {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），
//        它的 next 指针指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了。

//        创建一个哑节点
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
//        再创建一个指针，指向哑节点，循环定位到删除节点前
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
//        进行删除，哑节点的下一个就是头节点
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;

    }
//    获取长度的方法
    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }



}
//19. 删除链表的倒数第 N 个结点
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//进阶：你能尝试使用一趟扫描实现吗？
//三种解法，长度法，栈法，双指针法（一次遍历，思想比较好）

