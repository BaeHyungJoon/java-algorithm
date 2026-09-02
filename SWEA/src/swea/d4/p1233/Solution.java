package swea.d4.p1233;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			
			int N = Integer.parseInt(br.readLine());

			int result = 1;
			for (int i = 0; i < N; i++) {
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodeNumber = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				int childCount = st.countTokens();
				
				boolean isOperator = value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
				
				if (childCount == 0) {
					if (isOperator) {
						result = 0;
					}
				} else if (childCount == 2) {
					if (!isOperator) {
						result = 0;
					}
				} else {
					result = 0;
				}
				
			}

			output.append('#').append(testCase).append(' ').append(result).append('\n');
			
		}
		
		System.out.println(output);
		
	}

}