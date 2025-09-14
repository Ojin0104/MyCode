class Solution {
    public int trap(int[] height) {
        int rain = 0;
        int left = 0;
        int right = height.length-2;

        int maxLeft =height[0];
        int maxRight = height[height.length-1];
        int idx =0;
        while(left<=right){

            if(maxLeft<maxRight){
                maxLeft = Math.max(maxLeft,height[left]);
                rain += maxLeft-height[left++];
                
            }else{
                
                maxRight = Math.max(maxRight,height[right]);
                rain += maxRight-height[right--];

            }
        }

        return rain;
    }

    
}