package leetcode.medium;

import entity.ListNode;

public class TwoAddNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        定义两个node指针，一个是头节点，一个尾指针，不断后移增加节点，再定义一个进位变量
        ListNode head = null, tail = null;
        int carry = 0;
//        如果l1或者l2不为空的时候，就进行循环累加
        while (l1 != null || l2 != null) {
//            获取当前l1和l2的值，并加上进位变量
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
//            头节点为空的时候，创建一个新的节点，并且tail尾指针指向头节点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
//               头节点不为空的时候，新建节点接入链，tail尾指针后移指向新增的节点
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
//            计算进位值，赋值给零时进位变量
            carry = sum / 10;
//            l1和l2 指针后移
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
//        循环结束后，如果进位变量不为0，则还需要新建一个节点
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }

}
//  给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
//  并且每个节点只能存储一位数字。
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//    https://leetcode-cn.com/problems/add-two-numbers/

