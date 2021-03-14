package Sword2Offer09;

//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
// 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
//输入：["CQueue","appendTail","deleteHead","deleteHead"]
// [[],[3],[],[]]
//输出：[null,null,3,-1]

import java.util.Stack;

public class CQueue {
    private static Stack<Integer> stack1;
    private static Stack<Integer> stack2;
    static {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public CQueue() {


    }

    public void appendTail(int value) {
        if(stack2.size()==0){
            stack2.push(value);
        }else{
            while (stack2.size()!=0&&stack2.peek()!=null){
                stack1.push(stack2.pop());
            }
            stack1.push(value);
            while (stack1.size()!=0&&stack1.peek()!=null){
                stack2.push(stack1.pop());
            }
        }
    }

    public int deleteHead() {
        if(stack2.size()==0){
            return -1;
        }else {
            return stack2.pop();
        }
    }
}
