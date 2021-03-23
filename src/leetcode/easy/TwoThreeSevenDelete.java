package leetcode.easy;

import entity.ListNode;

public class TwoThreeSevenDelete {
    //        注意，这是一个方法，并没有传入 整个链

//    删除链表节点方法：1.通过操作指针，知道此节点的前一个指针来操作
//    但是：如果不知道前面的指针，如何进行操作
//    方法：把下一个的值复制到要删除的节点上，然后再去删除下一个节点
    public void deleteNode(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
        }
        node.next = node.next.next;
    }
}
//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
//输入：head = [4,5,1,9], node = 5
// 输出：[4,1,9]
// 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
