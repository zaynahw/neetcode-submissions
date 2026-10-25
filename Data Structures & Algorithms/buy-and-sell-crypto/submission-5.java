class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        for (int right = 1; right < prices.length; right++) {
            while (left < right && prices[left] > prices[right]) {
                left++;
            }
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
        }
        return maxProfit;
    }
}
