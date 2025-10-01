class Solution {
    public int maxProfit(int[] prices) {
        int maxpro =0;
        int minpro = prices[0];

        for(int i=0;i<prices.length;i++){
            if(prices[i]<minpro){
                minpro = prices[i];
            }
            maxpro = Math.max(maxpro, prices[i]-minpro);
        }
        return maxpro;

    }
}
