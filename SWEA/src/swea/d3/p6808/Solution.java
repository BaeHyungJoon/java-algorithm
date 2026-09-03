package swea.d3.p6808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
	
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] gyuCards = new int[9];
			for(int i = 0; i < 9; i++) {
				gyuCards[i] = Integer.parseInt(st.nextToken());
			}
			
					
			output.append("#").append(testCase).append(" ").append("\n");
			
		}
		
		System.out.println(output);
		
	}

}