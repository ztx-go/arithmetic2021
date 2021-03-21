package leetcode.easy;

import entity.ListNode;

public class TwoOneMerge {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//     我们直接将以上递归过程建模，同时需要考虑边界情况。
//如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。
// 否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。
// 如果两个链表有一个为空，递归结束
//
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.data < l2.data) {
//            将较小的节点作为已经有序的节点，他的下一个有序节点从 剩余的节点中选出
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
//    方便理解：返回一个最小的节点，然后再剩余的节点中 再去找一个最小的节点，重复直到l1或l2
//    其中一个为空
}
