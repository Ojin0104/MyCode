class Solution {
    public int maxProfit(int[] prices) {

        int sum = 0;
        int point= prices[0] ;
        int num = 0;
        for(int idx = 1; idx< prices.length ; idx++){
            
            if(prices[idx]>=point){
                num+= prices[idx]-point;
                point = prices[idx];
                continue;
            }

            if(prices[idx] < point){
                sum+= num;
                num = 0;
                point = prices[idx];

            }

        }
        sum+= num;
        return sum;
        
    }
}