package leetcode.medium;

import leetcode.utils.ListNode;

public class Linked_leetcode19 {
    // 关键信息提取 输入：链表、求什么：删除元素、倒数第n个、关键约束：无
    // 链表、倒数第n个 -> 双指针：保持n个间距、虚拟头指针dummy
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;

        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;
        
        for(int i=0; i<n; i++){
            right = right.next;
        }
        while(right!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
