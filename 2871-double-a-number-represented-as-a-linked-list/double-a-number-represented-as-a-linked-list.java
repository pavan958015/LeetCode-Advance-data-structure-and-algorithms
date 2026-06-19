class Solution {

    private ListNode copy(ListNode head){
        if(head==null) return null;

        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        while(head!=null){
            cur.next=new ListNode(head.val);
            cur=cur.next;
            head=head.next;
        }

        return dummy.next;
    }

    private ListNode addLists(ListNode l1,ListNode l2,int carry){
        if(l1==null && l2==null && carry==0) return null;

        int val1=(l1!=null)?l1.val:0;
        int val2=(l2!=null)?l2.val:0;

        int sum=val1+val2+carry;

        ListNode node=new ListNode(sum%10);

        node.next=addLists(
            l1!=null?l1.next:null,
            l2!=null?l2.next:null,
            sum/10
        );

        return node;
    }

    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode cur=head;

        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        return prev;
    }

    public ListNode doubleIt(ListNode head) {

        ListNode copyHead=copy(head);

        ListNode head1=reverseList(head);
        ListNode head2=reverseList(copyHead);

        ListNode ans=addLists(head1,head2,0);

        return reverseList(ans);
    }
}