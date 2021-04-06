package Sword2Offer18;

import java.util.List;

//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
//head = [4,5,1,9], val = 5  输出: [4,1,9]
// 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
public class MyTest {
    //思路：如果第一个节点就是结果，那么直接返回head.next
    //如果第一个节点不是结果，那么需要使用两个指针，cur和pre代表当前指针和上一个指针
    //如果当前指针是null或者当前指针的值是val，那么就退出循环，且返回head
    //如果当前指针是val，那么就将pre的指针给cur.next
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }else {
            ListNode cur = head;
            ListNode pre = null;
            while (cur!=null&&cur.val!=val){
                pre = cur;
                cur = cur.next;
            }
            if(cur.val==val){
                pre.next = cur.next;

            }
            return head;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
