package leetcode.top;

import entity.ListNode;
import leetcode.easy.OneTwoNineZeroConvert;

import java.util.Arrays;

public class TwoAdd {
//     2. 两数相加
//     给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//     请你将两个数相加，并以相同形式返回一个表示和的链表。
//     你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode pro = new ListNode(0);
        ListNode result = pro;
        while (l1 != null || l2 != null) {
            int number1 = l1 == null ? 0 : l1.val;
            int number2 = l2 == null ? 0 : l2.val;
            int sum = number1 + number2 + carry;
            pro.next = new ListNode(sum % 10);
            pro = pro.next;
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            pro.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {

        // 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        // 输出：[8,9,9,9,0,0,0,1]
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(9);
        ListNode node23 = new ListNode(9);
        ListNode node24 = new ListNode(9);
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;

        TwoAdd twoAdd = new TwoAdd();
        ListNode listNode = twoAdd.addTwoNumbers(node1, node21);
        System.out.println(listNode.toString());
    }
}
