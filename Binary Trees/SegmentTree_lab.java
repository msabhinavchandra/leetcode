import java.util.*;

class Solution {
    // Segment Tree Node
    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int val; // minimum available day in this segment

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.val = start; // initially, all days are available
        }
    }

    SegmentTreeNode root;

    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;

        // Step 1: Sort events by endDay
        Arrays.sort(events, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int lastDay = events[events.length - 1][1];
        int firstDay = Integer.MAX_VALUE;
        for (int[] event : events) {
            firstDay = Math.min(firstDay, event[0]);
        }

        // Step 2: Build segment tree from firstDay to lastDay
        root = buildSegmentTree(firstDay, lastDay);

        // Step 3: Attend events greedily using segment tree
        int count = 0;
        for (int[] event : events) {
            int earliestDay = query(root, event[0], event[1]);
            if (earliestDay != Integer.MAX_VALUE) {
                count++;
                update(root, earliestDay);
            }
        }

        return count;
    }

    // Build the segment tree recursively
    private SegmentTreeNode buildSegmentTree(int start, int end) {
        if (start > end) return null;

        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) return node;

        int mid = start + (end - start) / 2;
        node.left = buildSegmentTree(start, mid);
        node.right = buildSegmentTree(mid + 1, end);
        node.val = Math.min(node.left.val, node.right.val);

        return node;
    }

    // Query the smallest available day in range [left, right]
    private int query(SegmentTreeNode node, int left, int right) {
        if (node == null || left > right) return Integer.MAX_VALUE;

        if (node.start == left && node.end == right) return node.val;

        int mid = node.start + (node.end - node.start) / 2;

        if (right <= mid) return query(node.left, left, right);
        else if (left > mid) return query(node.right, left, right);
        else return Math.min(query(node.left, left, mid), query(node.right, mid + 1, right));
    }

    // Mark the given day as used (set to Integer.MAX_VALUE)
    private void update(SegmentTreeNode node, int day) {
        if (node.start == node.end) {
            node.val = Integer.MAX_VALUE;
            return;
        }
        
        int mid = node.start + (node.end - node.start) / 2;
        if (day <= mid) update(node.left, day);
        else update(node.right, day);

        node.val = Math.min(node.left.val, node.right.val);
    }
}
