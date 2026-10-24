class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] r = new int[k];
        HashMap<Integer, Integer> track = new HashMap<>();
        for (int n: nums) {
            track.put(n, track.getOrDefault(n, 0)+1);
        }

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
