class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] r = new int[k];
        HashMap<Integer, Integer> track = new HashMap<>();
        for (int n: nums) {
            track.put(n, track.getOrDefault(n, 0)+1);
        }

        // Custom comparator for max-heap based on frequency:
        // Integer.compare(x, y) returns negative if x < y, positive if x > y, and 0 if equal.
        // In a PriorityQueue comparator (a, b):
        //   Negative -> a has higher priority (comes out first)
        //   Positive -> b has higher priority (comes out first)
        //   Zero     -> equal priority (no guaranteed order)
        // Normally compare(a, b) prioritizes smaller values (min-heap).
        // Reversing to compare(b, a) prioritizes larger values (max-heap).
        // Here, track.get() compares frequencies instead of the numbers themselves,
        // so the number with the highest frequency comes out first.
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(track.get(b),track.get(a))
        );

        pq.addAll(track.keySet());

        for (int i = 0; i < r.length; i++) {
            r[i] = pq.poll();
        }
        return r;
    }
}
