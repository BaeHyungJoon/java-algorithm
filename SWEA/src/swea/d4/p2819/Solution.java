package swea.d4.p2819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int[][] grid = new int[4][4];
    static Set<Integer> results;

    // 상하좌우 델타 탐색
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            // 격자판 입력
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 완성된 7자리 수의 중복 제거
            // 테스트 케이스마다 새롭게 초기화
            results = new HashSet<>();

            // 모든 격자 칸을 시작점으로 BFS 수행
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    bfs(i, j);
                }
            }

            // 서로 다른 7자리 수의 개수
            int answer = results.size();

            output.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }

    static void bfs(int r, int c) {

        // 탐색 상태: {현재 행, 현재 열, 이동 횟수, 누적 숫자}
        Queue<int[]> queue = new ArrayDeque<>();

        // 시작 칸의 숫자를 포함하고 이동 횟수는 0으로 초기화
        queue.offer(new int[] {r, c, 0, grid[r][c]});

        while (!queue.isEmpty()) {

            // 현재 탐색 상태 추출
            int[] cur = queue.poll();

            int cr = cur[0];
            int cc = cur[1];
            int count = cur[2];
            int number = cur[3];

            // 6번 이동하면 시작 칸을 포함하여 7자리 수 완성
            if (count == 6) {
                results.add(number);

                // 현재 경로의 확장만 종료하고 나머지 경로는 계속 탐색
                continue;
            }

            // 상하좌우 이동 가능한 모든 경로 탐색
            for (int i = 0; i < 4; i++) {

                int nr = cr + dr[i];
                int nc = cc + dc[i];

                // 격자판을 벗어나는 경우 제외
                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) {
                    continue;
                }

                // 현재 상태를 변경하지 않고 새로운 탐색 상태 생성
                int nextCount = count + 1;
                int nextNumber = number * 10 + grid[nr][nc];

                // 재방문이 가능하므로 별도의 visited 검사 없이 삽입
                queue.offer(new int[] {nr, nc, nextCount, nextNumber});
            }
        }
    }
}