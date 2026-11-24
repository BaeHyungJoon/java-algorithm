package swea.d4.p2819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	static int[][] grid = new int[4][4];
	static Set<Integer> results;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// grid에서 임의의 위치에서 시작해서 상하좌우 인접한 격자로 6번 이동, 중복 가능, 이어붙여서 총 7자리 수
			// 숫자 겹치는 것과 격자 외부로 나가는 경우만 제외하고 개수 세기 알고리즘 구현하기

			int answer = 0;
			output.append('#').append(tc).append(' ').append(answer).append('\n');

		}

		System.out.print(output);

	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { r, c, 0, grid[r][c] });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			int count = cur[2];
			int number = cur[3];
		}
	}

}