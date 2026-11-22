/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one=headA;
        ListNode two=headB;

        while(one!=two){
            if(one==null){
                one=headB;
            }else{
                one=one.next;
            }
            if(two==null){
                two=headA;
            }else{
                two=two.next;
            }
        }
        return one;
    }
}