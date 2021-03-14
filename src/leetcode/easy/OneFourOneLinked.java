package leetcode.easy;

import entity.ListNode;

public class OneFourOneLinked {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode a = head;
        ListNode b = head.next;
        while (a != b && b.next != a) {
            a = a.next;
            if (b.next != null && b.next.next != null) {
                b = b.next.next;
            } else {
                return false;
            }

        }
        if (a.next == null) {
            return false;
        }
        return true;
    }
}

//给定一个链表，判断链表中是否有环。
//  如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
//  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
//  如果链表中存在环，则返回 true 。 否则，返回 false 。
