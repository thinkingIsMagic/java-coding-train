package leetcode.easy;

import leetcode.utils.ListNode;

public class Linked_leetcode206{
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}