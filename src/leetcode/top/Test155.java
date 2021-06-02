package leetcode.top;

import java.util.Deque;
import java.util.LinkedList;

public class Test155 {
    //设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    //
    // push(x) —— 将元素 x 推入栈中。
    // pop()—— 删除栈顶的元素。
    // top()-- 获取栈顶元素。
    // getMin() —— 检索栈中的最小元素。
    //
    public Deque<Integer> stack1;//注意现在栈使用Deque不用Stack来初始化了，new LinkList，方法和stack的一样
    public Deque<Integer> stack2;

    public Test155() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
        stack2.push(Integer.MIN_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(val, stack2.peek()));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        //    输入：
        // ["MinStack","push","push","push","getMin","pop","top","getMin"]
        // [[],[-2],[0],[-3],[],[],[],[]]
        // 输出：
        // [null,null,null,null,-3,null,0,-2]
        Test155 t = new Test155();
        t.push(-2);
        t.push(0);
        t.push(-3);
        t.getMin();
        t.pop();
        t.getMin();
    }
}
