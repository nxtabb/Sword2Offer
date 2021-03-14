package Sword2Offer06;

import java.util.Stack;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//示例:输入：head = [1,3,2],输出：[2,3,1]

//思路：将链表依次压入栈,然后在弹出放到一个数组中即可
public class MyTest {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] result = reversePrint(listNode1);
        for (int i : result) {
            System.out.println(i);
        }
    }
    public static int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[]{};
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        int[] arr = new int[stack.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = stack.pop().val;
        }
        return arr;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
