package swea.d5.p3421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[][] records;
	static boolean[] selected;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			records = new int[M][2];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				records[i][0] = Integer.parseInt(st.nextToken());
				records[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 모든 부분집합을 만들고 궁합 맞지 않은 재료가 같이 들어있는지 검증
			selected = new boolean[N+1];
			answer = 0;
			
			dfs(1);
			
			output.append('#').append(testCase).append(' ').append(answer).append('\n');
			
		}
		
		System.out.print(output);
		
	}
	
	static void dfs(int depth) {
		
		// 재귀 DFS 종료 조건
		if (depth == N + 1) {
			
			if(isValid()) {
				answer++;
			}
			
			return;
		}
		
		// 현재 depth의 재료를 선택할 때
		selected[depth] = true;
		dfs(depth + 1);
		
		// 현재 depth의 재료를 선택하지 않을 때
		selected[depth] = false;
		dfs(depth + 1);
		
	}
	
	static boolean isValid() {
		
		for (int i = 0; i < M; i++) {
			
			int a = records[i][0];
			int b = records[i][1];
			
			if (selected[a] && selected[b]) {
				return false;
			}
			
		}
		
		return true;
	}

}