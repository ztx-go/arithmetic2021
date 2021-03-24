package leetcode.easy;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

public class OneTwoNineZeroConvert {
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        int sum = 0;
        for (int i = size, j = 0; i > 0; i--, j++) {
            sum = sum +( list.get(i - 1)  << j);
        }
        return sum;
    }

//    正着算，num=0+当前节点的值  然后再一起乘2
    public int getDecimalValue2(ListNode head) {
        int num = 0;
        ListNode node = head;
        while(node != null){
            num = (num << 1) + node.val;//num << 1:有符号左移1位 相当于乘2
            node = node.next;
        }
        return num;
    }


    public static void main(String[] args) {
        OneTwoNineZeroConvert t = new OneTwoNineZeroConvert();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        int result = t.getDecimalValue(node1);
        System.out.println(result);
    }

}
