class KthLargest {
    private PriorityQueue<Integer> topK;
    private int k;
    public KthLargest(int k, int[] nums) {
        topK = new PriorityQueue<>();
        this.k = k;
       for (int n : nums) {
            topK.add(n);
       }

       if (topK.size() > k) {
        int remove = nums.length - k;
            for (int i = 0; i < remove; i++) {
                topK.remove();
            }
       }
    }
    
    public int add(int val) {
        if (topK.size() < k) {
            topK.add(val);
            return topK.peek();
        }
        
        if (val > topK.peek()) {
            topK.remove();
            topK.add(val);  
        }

        return topK.peek();
    }
}
