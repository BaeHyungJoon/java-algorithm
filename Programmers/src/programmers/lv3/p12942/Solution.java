package programmers.lv3.p12942;

class Solution {
	
    public int solution(int[][] matrix_sizes) {
    	
        int n = matrix_sizes.length;
        
        int[][] dp = new int[n][n];
        
        for (int len = 2; len <= n; len++) {

            for (int start = 0; start + len <= n; start++) {

                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;

                for (int k = start; k < end; k++) {

                    int cost = dp[start][k]
                             + dp[k + 1][end]
                             + matrix_sizes[start][0]
                             * matrix_sizes[k][1]
                             * matrix_sizes[end][1];

                    dp[start][end] =
                            Math.min(dp[start][end], cost);
                }
            }
        }
        
        return dp[0][n - 1];
        
    }
    
}