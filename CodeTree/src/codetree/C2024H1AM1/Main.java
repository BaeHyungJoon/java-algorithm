package codetree.C2024H1AM1;

import java.io.*;
import java.util.*;

public class Main {

    static final int N = 5;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static int[] wallPieces;
    static int wallIndex = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];

        // 최초 유적지 입력
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽면에 적힌 유물 조각 입력
        wallPieces = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            wallPieces[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 K번의 탐사 진행
        for (int turn = 0; turn < K; turn++) {

            int bestValue = 0;
            int[][] bestBoard = null;

            // 회전 각도 -> 중심 열 -> 중심 행 순서로 탐색
            // 이 순서 자체가 동점 우선순위를 보장한다.
            for (int times = 1; times <= 3; times++) {
                for (int c = 1; c <= 3; c++) {
                    for (int r = 1; r <= 3; r++) {

                        int[][] candidate = copyBoard(board);

                        // 90도 회전을 times번 수행
                        for (int t = 0; t < times; t++) {
                            candidate = rotate90(candidate, r, c);
                        }

                        // 회전 후 유물 1차 획득 가치 계산
                        int value = findArtifacts(
                                candidate, new boolean[N][N]);

                        // 획득 가치가 더 클 때만 갱신
                        if (value > bestValue) {
                            bestValue = value;
                            bestBoard = candidate;
                        }
                    }
                }
            }

            // 어떤 방법으로도 유물을 얻을 수 없다면 종료
            if (bestValue == 0) {
                break;
            }

            // 가장 유리한 회전 결과를 실제 유적지에 반영
            board = bestBoard;

            int turnTotal = 0;

            // 유물 1차 획득 및 연쇄 획득
            while (true) {

                boolean[][] removed = new boolean[N][N];

                // 현재 유적지에서 획득할 수 있는 유물 탐색
                int gained = findArtifacts(board, removed);

                // 더 이상 획득할 유물이 없다면 연쇄 종료
                if (gained == 0) {
                    break;
                }

                turnTotal += gained;

                // 사라진 위치에 새로운 조각 채우기
                refill(board, removed);
            }

            if (answer.length() > 0) {
                answer.append(' ');
            }

            answer.append(turnTotal);
        }

        System.out.println(answer);
    }

    // 5x5 배열 깊은 복사
    static int[][] copyBoard(int[][] board) {

        int[][] copied = new int[N][N];

        for (int r = 0; r < N; r++) {
            copied[r] = board[r].clone();
        }

        return copied;
    }

    // 중심 (centerR, centerC)의 3x3 영역을 시계 방향 90도 회전
    static int[][] rotate90(int[][] board, int centerR, int centerC) {

        int[][] rotated = copyBoard(board);

        int top = centerR - 1;
        int left = centerC - 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                rotated[top + j][left + 2 - i]
                        = board[top + i][left + j];
            }
        }

        return rotated;
    }

    // BFS로 유물 그룹 탐색
    // 3개 이상 연결된 그룹의 총 조각 개수를 반환
    // 제거 대상 좌표는 removed에 기록
    static int findArtifacts(int[][] board, boolean[][] removed) {

        boolean[][] visited = new boolean[N][N];
        int total = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                if (visited[r][c]) {
                    continue;
                }

                List<int[]> group = new ArrayList<>();

                visited[r][c] = true;
                queue.offer(new int[]{r, c});

                // 같은 종류의 유물 조각을 BFS로 탐색
                while (!queue.isEmpty()) {

                    int[] current = queue.poll();

                    int cr = current[0];
                    int cc = current[1];

                    group.add(current);

                    for (int d = 0; d < 4; d++) {

                        int nr = cr + dr[d];
                        int nc = cc + dc[d];

                        // 격자 범위 확인
                        if (nr < 0 || nr >= N ||
                            nc < 0 || nc >= N) {
                            continue;
                        }

                        // 이미 방문했거나 다른 종류의 조각이면 제외
                        if (visited[nr][nc] ||
                            board[nr][nc] != board[cr][cc]) {
                            continue;
                        }

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }

                // 3개 이상 연결되었다면 유물 획득
                if (group.size() >= 3) {

                    total += group.size();

                    for (int[] pos : group) {
                        removed[pos[0]][pos[1]] = true;
                    }
                }
            }
        }

        return total;
    }

    // 사라진 유물 조각을 벽면의 숫자로 채우기
    static void refill(int[][] board, boolean[][] removed) {

        // 열 번호가 작은 순서
        for (int c = 0; c < N; c++) {

            // 같은 열에서는 행 번호가 큰 순서
            for (int r = N - 1; r >= 0; r--) {

                if (removed[r][c]) {

                    board[r][c] = wallPieces[wallIndex];
                    wallIndex++;
                }
            }
        }
    }
}
