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
    public static ListNode reverse(ListNode head){
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public int[] nextLargerNodes(ListNode head) {
        head=reverse(head);
        Stack<Integer> st=new Stack<>();

        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int res[]=new int[count];
        int i=count-1;

        while(head!=null){
            while(!st.isEmpty() && st.peek()<=head.val)
                st.pop();
            
            res[i--]=st.isEmpty()?0:st.peek();
            st.push(head.val);
            head=head.next;
        }
        return res;
    }
}