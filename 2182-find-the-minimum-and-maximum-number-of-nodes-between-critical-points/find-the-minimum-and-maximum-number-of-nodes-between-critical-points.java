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