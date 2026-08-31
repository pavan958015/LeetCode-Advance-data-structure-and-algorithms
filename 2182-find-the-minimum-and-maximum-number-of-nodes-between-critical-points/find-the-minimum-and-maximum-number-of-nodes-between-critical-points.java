/*
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        List<Integer> list = new ArrayList<>();
        ListNode prev = null;
        ListNode curr = head;
        int pos = 0;

        while (curr != null && curr.next != null) {
            if (prev != null) {
                if ((curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val)) {
                    list.add(pos);
                }
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }

        if (list.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDist = Integer.MAX_VALUE;
        int maxDist = list.get(list.size() - 1) - list.get(0);

        for (int i = 1; i < list.size(); i++) {
            minDist = Math.min(minDist, list.get(i) - list.get(i - 1));
        }

        return new int[]{minDist, maxDist};
    }
}

*/
class Solution {
    private int length(ListNode head) {
        ListNode cur = head;

        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int n = length(head);

        if (n <= 2) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode cur = head.next;

        int index = 1;

        int first = -1;
        int last = -1;

        int min = Integer.MAX_VALUE;

        while (cur != null && cur.next != null) {

            boolean isCritical = false;

            // Local minima
            if (cur.val < prev.val && cur.val < cur.next.val) {
                isCritical = true;
            }

            // Local maxima
            if (cur.val > prev.val && cur.val > cur.next.val) {
                isCritical = true;
            }

            if (isCritical) {

                // First critical point
                if (first == -1) {
                    first = index;
                } else {
                    // Distance from previous critical point
                    min = Math.min(min, index - last);
                }

                last = index;
            }

            prev = cur;
            cur = cur.next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        int max = last - first;

        return new int[]{min, max};
    }
}