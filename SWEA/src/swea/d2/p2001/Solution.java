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
		
			// 파리개수 받아두는 맵
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					flyMap[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// fly_map에서 가장 큰 2*2를 찾기
			// row 방향 size 2 누적합 구하기
			int[][] rowSum = new int[N][N-M+1]; 
			
			for (int row = 0; row < N; row++) {
				Queue<Integer> queue = new ArrayDeque<>();
				int sum = 0;
				
				// 첫 번째 같은 row에 col M개 rowSum 
				for (int c = 0; c<M; c++) {
					queue.offer(flyMap[row][c]);
					sum += flyMap[row][c];
				}
				
				rowSum[row][0] = sum;
				
				// 오른쪽으로 한칸씩 이동
				for (int c = M; c < N; c++) {
					int removed = queue.poll();
					sum -= removed;
					
					int value = flyMap[row][c];
					queue.offer(value);
					sum += value;
					
					int startCol = c - M + 1;
					rowSum[row][startCol] = sum;
				}
			}
			
			// 세로 sliding window 진행
			int result = 0;
			
			for (int col = 0; col < N-M+1; col++) {
				Queue<Integer> queue = new ArrayDeque<>();
				int sum = 0;
				
				// 첫 번째 같은 col에서 row M개 
				for (int r = 0; r < M; r++) {
					queue.offer(rowSum[r][col]);
					sum += rowSum[r][col];
				}
				
				result = Math.max(result, sum);
				
				for (int r = M; r < N; r++) {
					int removed = queue.poll();
					sum -= removed;
					
					int value = rowSum[r][col];
					queue.offer(value);
					sum += value;
					
					result = Math.max(result, sum);
				}
			}
			output.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		System.out.println(output);
	}
}