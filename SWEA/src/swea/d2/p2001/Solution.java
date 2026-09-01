package swea.d2.p2001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] flyMap = new int[N][N];
			int[][] groupSum = new int[N][N-M+1];
		
			// 파리개수 받아두는 맵
			for (int i = 0; i < N; i++) {
				StringTokenizer fly = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					flyMap[i][j] = Integer.parseInt(fly.nextToken());
				}
			}

			int result = 0;
			// fly_stick으로 fly_map에서 가장 큰 2*2를 찾기
			Queue<Integer> queue = new ArrayDeque<>();
			
			
			
	
			output.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(output);
	}
}