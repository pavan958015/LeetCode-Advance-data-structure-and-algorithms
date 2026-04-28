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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addLists(l1,l2,0);
    }
    private ListNode addLists(ListNode l1,ListNode l2,int carry){
        if(l1==null && l2==null && carry==0) return null;

        int val1= (l1!=null)?l1.val:0;
        int val2= (l2!=null)?l2.val:0;
        int total=val1+val2+carry;
        int newdigit=total%10;
        int newCarry=total/10;

        ListNode cur=new ListNode(newdigit);

        ListNode next1=(l1!=null)?l1.next:null;
        ListNode next2=(l2!=null)?l2.next:null;

        cur.next=addLists(next1,next2,newCarry);

        return cur;

    }
}