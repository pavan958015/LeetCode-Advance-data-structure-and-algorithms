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
    // merger Two LinkedList;
    public static ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode node=new ListNode();
        ListNode ans=node;

        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                ans.next=l2;
                l2=l2.next;
            }else{
                ans.next=l1;
                l1=l1.next;;
            }
            ans=ans.next;
        }
        ans.next=l1!=null?l1:l2;

        return node.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 || lists==null) return null;

        while(lists.length>1){
            List<ListNode> temp=new ArrayList();

            for(int i=0;i<lists.length;i+=2){
                ListNode l1=lists[i];
                ListNode l2=i+1<lists.length?lists[i+1]:null;

                temp.add(mergeTwoList(l1,l2));
            }
            lists=temp.toArray(new ListNode[0]);
        }
        return lists[0];
    }
}