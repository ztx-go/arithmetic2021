package leetcode.top;

import entity.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Test142 {

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    // 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    // 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
    // 说明：不允许修改给定的链表。
    // 进阶： 你是否可以使用 O(1) 空间解决此题？
    public ListNode detectCycle(ListNode head) {

        Map<ListNode, Integer> map = new HashMap<>();
        ListNode result = head;
        int i = 0;
        while (result != null) {
            if (map.containsKey(result)) {
                return result;
            }
            map.put(result, i++);
            result = result.next;
        }
        return null;
    }

    // 进阶解法：快慢指针的方法，a：头节点到入环节点的距离；b：入环节点到相遇节点的距离；c：相遇节点到入环节点的距离
    //快=2*慢   a+b+c=2*(a+b)  推理可以得出，a=c
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            //fast和slow先走自己的步长
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;
            //相遇了
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Test142 t = new Test142();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode listNode = t.detectCycle(node1);
        System.out.println(listNode);
    }
}
