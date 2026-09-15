package swea.d4.p1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static boolean[][] tunnel = { {}, { true, true, true, true }, // 1번: 상 하 좌 우
			{ true, true, false, false }, // 2번: 상 하
			{ false, false, true, true }, // 3번: 좌 우
			{ true, false, false, true }, // 4번: 상 우
			{ false, true, false, true }, // 5번: 하 우
			{ false, true, true, false }, // 6번: 하 좌
			{ true, false, true, false } // 7번: 상 좌
	};

	static int[] opposite = { 1, 0, 3, 2 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]> queue = new ArrayDeque<>();
			int count = 1;

			queue.offer(new int[] { R, C, 1 });
			visited[R][C] = true;

			while (!queue.isEmpty()) {
				int[] current = queue.poll();

				int r = current[0];
				int c = current[1];
				int time = current[2];
				
				if (time == L) {
			        continue;
			    }

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
						continue;
					}
					if (map[nr][nc] == 0) {
						continue;
					}
					if (visited[nr][nc]) {
						continue;
					}
					if (!tunnel[map[r][c]][d]) {
						continue;
					}
					if (!tunnel[map[nr][nc]][opposite[d]]) {
						continue;
					}
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc, time + 1 });
					count++;
				}
			}
			output.append('#').append(testCase).append(' ').append(count).append('\n');

		}

		System.out.print(output);

	}

}