package swea.d3.p3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 물건 개수 (1~100)
			int K = Integer.parseInt(st.nextToken()); // 가방 최대 부피 (1~1000)
			
			int[] volumn = new int[N+1]; // 물건 하나의 부피 (index 0은 buffer, 1~100)
			int[] cost = new int[N+1]; // 물건 하나의 가치 (index 0은 buffer, 1~100)
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				volumn[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			// dp[i][w]: 앞의 i개 물건으로
	        // 용량 w 이하에서 얻을 수 있는 최대 가치
	        int[][] dp = new int[N + 1][K + 1];

	        for (int i = 1; i <= N; i++) {
	            for (int w = 0; w <= K; w++) {

	                // 현재 물건을 선택하지 않는 경우
	                dp[i][w] = dp[i - 1][w];

	                // 현재 물건을 선택할 수 있는 경우
	                if (w >= volumn[i]) {
	                    dp[i][w] = Math.max(
	                        dp[i][w],
	                        dp[i - 1][w - volumn[i]] + cost[i]
	                    );
	                }
	            }
	        }
	        
	        int answer = dp[N][K];
			
			output.append('#').append(testCase).append(' ').append(answer).append('\n');
			
		}
		
		System.out.print(output);
		
	}

}