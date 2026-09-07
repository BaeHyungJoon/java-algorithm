package swea.d3.p5215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int L;
	
	static int[] score;
	static int[] cal;
	
	static int result;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			
			dfs(0, 0, 0);
			
			output.append('#').append(testCase).append(' ').append(result).append('\n');
			
		}
		
		System.out.print(output);
		
	}
	
	static void dfs(int index, int currentScore, int currentCal) {
		
		if (currentCal > L) {
			return;
		}
		
		if (index == N) {
			result = Math.max(result, currentScore);
			return;
		}
		
		dfs(index+1, currentScore+score[index], currentCal+cal[index]);
		
		dfs(index+1, currentScore, currentCal);
		
	}

}