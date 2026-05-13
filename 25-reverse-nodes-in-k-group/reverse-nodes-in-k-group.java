class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy.next;

        while (cur != null) {
            ListNode kth = findKth(cur, k);

            if (kth == null) {
                prev.next = cur;
                break;
            }

            ListNode next = kth.next;
            kth.next = null;

            prev.next = reverse(cur);
            prev = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static ListNode findKth(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}