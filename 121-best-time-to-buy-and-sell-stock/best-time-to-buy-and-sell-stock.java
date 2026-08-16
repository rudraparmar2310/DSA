class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int p=0;
        int left=0;       
        for(int right=0;right<prices.length;right++){
            if(prices[left]<prices[right]){

                p=Math.max(p,prices[right]-prices[left]);
            }
            else{
                left=right;
            }
        }
        return p;
    }
}