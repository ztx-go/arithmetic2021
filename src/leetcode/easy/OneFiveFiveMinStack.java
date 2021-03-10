package leetcode.easy;

import java.util.Stack;

public class OneFiveFiveMinStack {
//  155题：最小栈
    //    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//    push(x) —— 将元素 x 推入栈中。
//    pop() —— 删除栈顶的元素。
//    top() —— 获取栈顶元素。
//    getMin() —— 检索栈中的最小元素。
//======================
//思想：
//    通过一个辅助栈，来存最小值，每次主栈存值的时候，辅助栈就比较最上面的值，哪个小就存哪个
//    初始化的时候存入Integer的最大值，这样就能保证辅助栈里最上面的值是最小值
//    当pop时，辅助栈也进行pop（这道题最难的部分就是常数时间内检索最小元素）
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public OneFiveFiveMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int i) {
        stack.push(i);
        minStack.push(Math.min(minStack.peek(), i));
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
