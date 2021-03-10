package entity;
//自定义一个链表节点node
public class ListNode2 {
    private Object data;
    private ListNode2 next;

    public ListNode2(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ListNode2 getNext() {
        return next;
    }

    public void setNext(ListNode2 next) {
        this.next = next;
    }

    public void getList(ListNode2 node) {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
