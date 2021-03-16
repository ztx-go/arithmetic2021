package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoTwoFiveImplent {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public TwoTwoFiveImplent() {
//        队列使用 linkedList
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

//        一个队列的方式，先获取队列长度，存入队尾x，循环将队头的元素重新再入队
//        int n = queue.size();
//        queue.offer(x);
//        for (int i = 0; i < n; i++) {
//            queue.offer(queue.poll());


    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
