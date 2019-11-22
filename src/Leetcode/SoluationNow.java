package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ZhaoMin
 * @date 2019/10/1 23:54
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class SoluationNow {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack1=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        ListNode cur=listNode;
        if(listNode==null){
            return null;
        }
        // stack.push(cur);
        while(cur!=null){
            stack1.push(cur);
            cur=cur.next;
        }
        while(!stack1.isEmpty()){
            list.add(stack1.pop().val);
        }
        return list;
    }

    public static void main(String[] args) {
        SoluationNow ob=new SoluationNow();
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(5);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;

        ob.printListFromTailToHead(n1);
        System.out.println( ob.printListFromTailToHead(null));
    }
}