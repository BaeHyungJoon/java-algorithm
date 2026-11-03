package swea.d4.p4040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			String str = new String(br.readLine());
			
			
			
			int answer = 0;
			
			output.append('#').append(testCase).append(' ').append(answer).append('\n');
			
		}
		
		System.out.print(output);
		
	}

}