class Solution {
    int[][]dp;
    int n ;

    public int solve(int[] nums, int i, int prev){
        if(i>=n)return 0;
        if(prev!=-1 && dp[i][prev]!=-1){
            return dp[i][prev];
        }
        int take=0;
        if(prev==-1 || nums[prev]< nums[i]){
            take = 1+solve(nums,i+1,i);
        }
        int skip = solve(nums,i+1,prev);
        if(prev!=-1){
            dp[i][prev] = Math.max(take,skip);
        }

        return Math.max(take,skip);

    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp= new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,-1);
    }
}
