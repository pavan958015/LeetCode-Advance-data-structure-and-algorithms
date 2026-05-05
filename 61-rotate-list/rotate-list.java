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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        // first find the length of the list;
        int len=1;
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        k=k%len;
        if(k==0) return head;

        cur.next=head;
        cur=head;
        for(int i=0;i<len-k-1;i++){
            cur=cur.next;
        }
        head=cur.next;
        cur.next=null;

        return head;
    }
}