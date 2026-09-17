package swea.d4.p1232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				
				st = new StringTokenizer(br.readLine());
				
				// (막힌 부분 1 : 정점 입력받기)
				int tokenCount = st.countTokens();
				if (tokenCount == 2) {
					int node = Integer.parseInt(st.nextToken());
					int value = Integer.parseInt(st.nextToken());
				} else if (tokenCount == 4) {
					int node = Integer.parseInt(st.nextToken());
					String operator = st.nextToken();
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
				}
				
				
			}
			
			output.append('#').append(testCase).append(' ').append('\n');
			
		}
		
		System.out.print(output);
		
	}

}