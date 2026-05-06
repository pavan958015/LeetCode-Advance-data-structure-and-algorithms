/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode newNode =new ListNode(head.val);
        ListNode temp=newNode;
        ListNode cur=head.next;

        while(cur!=null){
            if(cur.val!=temp.val){
                temp.next=cur;
                temp=temp.next;
            }
            cur=cur.next;
        }
        temp.next=null;
        return newNode;
    }
}