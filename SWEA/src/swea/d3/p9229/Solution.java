package swea.d3.p9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[] cookies;
	static int[] selected;
	static int result;

	public static void main(String[] args) throws IOException{
		
		int TC = Integer.parseInt(input.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
		
			st = new StringTokenizer(input.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cookies = new int[N];
			
			st = new StringTokenizer(input.readLine());
			for (int i = 0; i < N; i++) {
				cookies[i] = Integer.parseInt(st.nextToken());
			}
			
			result = -1; // 가능한 두 봉지가 없으면 -1이므로 초기값을 -1로 설정
			selected = new int[2]; // 선택된 과자 봉지 2개를 저장하는 배열
			
			combination(0, 0);
			
			output.append('#').append(testCase).append(" ").append(result).append('\n');
			
		}
		
		System.out.print(output);
		
	}
	
	static void combination(int cnt, int start) {
		
		if (cnt == 2) {
			int totalWeight = selected[0] + selected[1];
			if (totalWeight <= M) {
				result = Math.max(result, totalWeight);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			selected[cnt] = cookies[i];
			combination(cnt+1, i+1);
		}
		
	}

}