package swea.d4.p1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, B, answer;
	static int[] record;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 점원 수
			B = Integer.parseInt(st.nextToken()); // 선반 높이

			record = new int[N]; // 점원들의 키 저장 int 배열
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				record[i] = Integer.parseInt(st.nextToken()); // 점원들의 키 저장 완료
			}
			
			// 점원 수가 20명 이하이므로 점원이 선택될지, 안될지 2가지 경우의 수가 각각 있으니깐 2^20 = 약 100만개 경우의 수 존재
			// 완전탐색 재귀 DFS 구현
			
			answer = Integer.MAX_VALUE;
			dfs(0,0);
			output.append('#').append(testCase).append(' ').append(answer).append('\n');

		}

		System.out.print(output);

	}

	static void dfs(int index, int sum) {
		if (sum >= B) {
			answer = Math.min(answer, sum-B);
			return;
		}
		
		if (index == N) {
			return;
		}
		
		dfs(index+1, sum + record[index]);
		
		dfs(index+1, sum);
		
	}

}