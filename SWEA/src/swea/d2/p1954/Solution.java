package swea.d2.p1954;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {

            int N = Integer.parseInt(br.readLine().trim());
            int[][] snail = new int[N][N];

            // 오른쪽, 아래, 왼쪽, 위
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            int row = 0;
            int col = 0;
            int direction = 0;

            for (int number = 1; number <= N * N; number++) {

                // 현재 위치에 숫자 저장
                snail[row][col] = number;

                // 마지막 숫자를 저장했다면 더 이상 이동할 필요가 없다.
                if (number == N * N) {
                    break;
                }

                // 현재 방향으로 다음 위치 계산
                int nextRow = row + dr[direction];
                int nextCol = col + dc[direction];

                /*
                 * 다음 위치가
                 * 1. 배열 범위를 벗어나거나
                 * 2. 이미 숫자가 채워진 칸이라면
                 * 방향을 시계방향으로 변경한다.
                 */
                if (nextRow < 0 || nextRow >= N
                        || nextCol < 0 || nextCol >= N
                        || snail[nextRow][nextCol] != 0) {

                    direction = (direction + 1) % 4;

                    nextRow = row + dr[direction];
                    nextCol = col + dc[direction];
                }

                // 다음 위치로 이동
                row = nextRow;
                col = nextCol;
            }

            // 출력
            result.append("#").append(testCase).append("\n");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result.append(snail[i][j]);

                    if (j < N - 1) {
                        result.append(" ");
                    }
                }
                result.append("\n");
            }
        }

        System.out.print(result);
    }
}