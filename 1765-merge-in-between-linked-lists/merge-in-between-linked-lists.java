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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // ListNode cur=list1;
        // int len=0;
        // ListNode lastofList2=list2;
        // while(lastofList2.next!=null){
        //     lastofList2=lastofList2.next;
        // }
        // while(cur!=null){
        //     cur=cur.next;
        //     len++;
        //     if(len+1==a){
        //         cur.next=list2;  // here I added whole list 2 that is worng
        //     }
        //     if(len==b){
        //         lastofList2.next=cur.next;
        //     }
        // }
        // return list1;


        ListNode start=null;
        ListNode end=list1;

        for(int i=0;i<b;i++){
            if(i+1==a){
                start=end;
            }
            end=end.next;
        }
        ListNode lastOfList2=list2;

        while(lastOfList2.next!=null)
            lastOfList2=lastOfList2.next;

        start.next=list2;
        lastOfList2.next=end.next;

        return list1;
    }
}