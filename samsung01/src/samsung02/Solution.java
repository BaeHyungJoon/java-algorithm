package samsung02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[][] map;

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 로봇이 이동 가능한 곳이 여러개인 경우, 로봇의 오른쪽, 앞쪽, 왼쪽, 뒤쪽의 순서로 가장 먼저 이동 가능한 곳으로 이동한다.
	static int[] turnOrder = { 1, 0, 3, 2 };

	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];

			// NxN 지형이 산인지 농지인지 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// M일동안 로봇이 가장 많이 수확한 횟수
			result = 0;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					// 맵에서 산인 경우 제외하기
					if (map[row][col] == 1) {
						continue;
					}

					// 산 아닐 때 이동시
					for (int direction = 0; direction < 4; direction++) {
						result = Math.max(result, simulate(row, col, direction));
					}
				}
			}

			output.append('#').append(testCase).append(' ').append(result).append('\n');

		}

		System.out.print(output);

	}

	static int simulate(int startRow, int startCol, int startDirection) {
		int[][] harvestDay = new int[N][N];
		int[][] growCount = new int[N][N];

		int row = startRow;
		int col = startCol;
		int direction = startDirection;
		int harvested = 0;

		for (int day = 1; day <= M; day++) {
			// 해당 row와 col의 harvestDay가 빈 농지가 아니고 M보다 작은 상황에서  만나면 수확하고 빈농지로 만들기
			if (harvestDay[row][col] != 0 && harvestDay[row][col] <= day) {
				harvested++;
				harvestDay[row][col] = 0;
			// 다음에 만날 row와 col의 harvestDay가 빈농지이고, 이동할 수 있다면 해
			} else if (harvestDay[row][col] == 0 && canMove(row, col, direction, day, harvestDay)) {
				int count = ++growCount[row][col];
				harvestDay[row][col] = day + count + 4;
			}
			
			for (int turn : turnOrder) {
				int nextDirection = (direction + turn) % 4;
				int nextRow = row + dr[nextDirection];
				int nextCol = col + dc[nextDirection];
				
				if (isMovable(nextRow, nextCol, day, harvestDay)) {
					row = nextRow;
					col = nextCol;
					direction = nextDirection;
					break;
				}
			}
		}

		return harvested;
	}

	static boolean canMove(int row, int col, int direction, int day, int[][] harvestDay) {
		for (int turn : turnOrder) {
			int nextDirection = (direction + turn) % 4;
			int nextRow = row + dr[nextDirection];
			int nextCol = col + dc[nextDirection];

			if (isMovable(nextRow, nextCol, day, harvestDay)) {
				return true;
			}
		}
		return false;
	}

	static boolean isMovable(int row, int col, int day, int[][] harvestDay) {
		if (row < 0 || row >= N || col < 0 || col >= N || map[row][col] == 1) {
			return false;
		}
		
		return harvestDay[row][col] == 0||harvestDay[row][col] <= day;
	}

}
