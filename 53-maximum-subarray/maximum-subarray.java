class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum=Integer.MIN_VALUE;
        int curSum= 0;
        for(int i=0;i<n;i++){
            curSum=curSum+nums[i];
            if(curSum>maxSum)               
               maxSum = Math.max(maxSum,curSum);
               if (curSum<0){
                    curSum=0;
               }
            }     
        return maxSum;
}
}