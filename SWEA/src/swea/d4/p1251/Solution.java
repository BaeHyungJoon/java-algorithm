package swea.d4.p1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			
			// 정점 개수 입력
			int N = Integer.parseInt(br.readLine());
			
			// 각 정점별 X좌표, Y좌표 입력
			long[] xCoor = new long[N];
			long[] yCoor = new long[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xCoor[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yCoor[i] = Integer.parseInt(st.nextToken());
			}
			
			// 환경세율 입력
			double taxRate = Double.parseDouble(br.readLine());
			
			// =============== MST 구현을 위한 Prim 알고리즘 ===============

			boolean[] visited = new boolean[N];
			long[] minDist = new long[N];
			long total = 0;
			
			Arrays.fill(minDist, Long.MAX_VALUE);
			minDist[0] = 0;
			
			for (int count = 0; count < N; count++) {
				
				int minVertex = -1;
				long min = Long.MAX_VALUE;
				
				for (int i = 0; i < N; i++) {
					if (visited[i]) {
						continue;
					}
					
					if (minDist[i] < min) {
						min = minDist[i];
						minVertex = i;
					}
				}
				
				visited[minVertex] = true;
				total += min;
				
				for (int i = 0; i < N; i++) {
					if (visited[i]) {
						continue;
					}
					long dx = xCoor[minVertex] - xCoor[i];
					long dy = yCoor[minVertex] - yCoor[i];
					long dist = dx * dx + dy * dy;
					if (dist < minDist[i]) {
						minDist[i] = dist;
					}
				}
				
			}
			
			long answer = Math.round(total * taxRate);
			
			// =============================================================
			
			// 각 테스트 케이스 정답 출력
			output.append("#").append(testCase).append(" ").append(answer).append("\n");
			
		}
		
		System.out.print(output);
		
	}

}