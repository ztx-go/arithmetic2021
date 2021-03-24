package leetcode.easy;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class EightThreeDelete {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = first;
        while (first.next != null) {
            while (first.val == first.next.val) {
                if (first.next.next == null) {
                    first.next = null;
                    return second;
                }
                first.next = first.next.next;
            }
            first = first.next;
        }
        return second;
    }

//  官方答案
    public ListNode deleteDuplicates2(ListNode head) {
        List<Integer> list=new ArrayList<>();
        int size = list.size();

        ListNode current = head;
//        当前指针和下一个不为空时
        while (current != null && current.next != null) {
//            当前和下一个值相等的时候，就跳过下一个
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;


    }

}
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。