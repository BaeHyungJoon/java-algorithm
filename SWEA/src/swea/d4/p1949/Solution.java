package swea.d4.p1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			int maxHeight = 0;
			result = 0;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
			    for (int j = 0; j < N; j++) {
			        if (map[i][j] == maxHeight) {
			            visited[i][j] = true;
			            dfs(i, j, 1, false);
			            visited[i][j] = false;
			        }
			    }
			}

			output.append('#').append(testCase).append(' ').append(result).append('\n');

		}

		System.out.print(output);

	}

	static void dfs(int r, int c, int length, boolean usedCut) {
		result = Math.max(result, length);

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			
			if (visited[nr][nc]) {
				continue;
			}
			
			if (map[nr][nc] < map[r][c]) {
				visited[nr][nc] = true;
				dfs(nr, nc, length+1, usedCut);
				visited[nr][nc] = false;
			}
			
			else if (!usedCut && map[nr][nc] - K < map[r][c]) {
				int original = map[nr][nc];
				map[nr][nc] = map[r][c] - 1;
				visited[nr][nc] = true;
				dfs(nr, nc, length+1, true);
				visited[nr][nc] = false;
				map[nr][nc] = original;
			}
		}
	}

}