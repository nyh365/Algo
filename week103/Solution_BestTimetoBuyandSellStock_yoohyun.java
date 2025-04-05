class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;

        for(int i = 1; i < prices.length; i++) {
            int temp = prices[i] - min;

            result = Math.max(result, temp);
            min = Math.min(min, prices[i]);
        }

        return result;
    }
}
