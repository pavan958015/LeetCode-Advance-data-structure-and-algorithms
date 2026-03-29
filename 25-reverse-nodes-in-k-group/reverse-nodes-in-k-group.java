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
    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static ListNode findNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while (temp != null) {
            ListNode kthNode = findNode(temp, k);

            if (kthNode == null) {
                if (prevNode != null)
                    prevNode.next = temp;
                break;
            } else {
                nextNode = kthNode.next;
                kthNode.next = null;

                ListNode newNode = reverse(temp);

                if (temp == head) {
                    head = kthNode;
                } else {
                    prevNode.next = kthNode;
                }
                prevNode = temp;
                temp = nextNode;
            }
        }
        return head;
    }
}