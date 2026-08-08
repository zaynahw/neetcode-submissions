class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left+1;
        int maxProfit = 0;
        for (int i=left; i<prices.length; i++){
            if (right >= prices.length) {
                break;
            }
            int profit = prices[right] - prices[left];
            if (profit < 0) {
                left = right;
                right = left + 1;
            } else {
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
                right++;
            }
        }
        return maxProfit;
    }
}
