package samsung01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static Home[] homes;

    static final int MIN = -15;
    static final int MAX = 15;
    static final int SIZE = 31;
    static final int INF = Integer.MAX_VALUE;

    static class Home {
        int x;
        int y;
        int limit;

        Home(int x, int y, int limit) {
            this.x = x;
            this.y = y;
            this.limit = limit;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            N = Integer.parseInt(br.readLine());

            homes = new Home[N];

            // 집이 있는 위치인지 빠르게 확인하기 위한 배열
            boolean[][] isHome = new boolean[SIZE][SIZE];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                homes[i] = new Home(x, y, dist);

                // 좌표 -15 ~ 15를 배열 인덱스 0 ~ 30으로 변환
                isHome[x + 15][y + 15] = true;
            }

            int answer = solve(isHome);

            output.append('#')
                  .append(testCase)
                  .append(' ')
                  .append(answer)
                  .append('\n');
        }

        System.out.print(output);
    }

    static int solve(boolean[][] isHome) {

        /*
         * 충전소 후보는 최대 31 * 31 = 961개
         *
         * candidateX[k], candidateY[k]
         * = k번째 충전소 후보의 실제 좌표
         */
        int[] candidateX = new int[SIZE * SIZE];
        int[] candidateY = new int[SIZE * SIZE];

        int candidateCount = 0;

        // ---------------------------------------------------
        // 1. 집이 아닌 모든 좌표를 충전소 후보로 저장
        // ---------------------------------------------------
        for (int x = MIN; x <= MAX; x++) {
            for (int y = MIN; y <= MAX; y++) {

                // 집이 있는 곳에는 충전소를 지을 수 없음
                if (isHome[x + 15][y + 15]) {
                    continue;
                }

                candidateX[candidateCount] = x;
                candidateY[candidateCount] = y;
                candidateCount++;
            }
        }

        /*
         * distance[c][h]
         * = c번째 충전소 후보와 h번째 집 사이 거리
         *
         * coverMask[c]
         * = c번째 충전소가 어떤 집들을 사용 가능하게 하는지 비트마스크
         *
         * N <= 20이므로 int 비트마스크 사용 가능
         */
        int[][] distance = new int[candidateCount][N];
        int[] coverMask = new int[candidateCount];

        // ---------------------------------------------------
        // 2. 모든 충전소 후보에 대해 거리와 커버 가능 집 계산
        // ---------------------------------------------------
        for (int c = 0; c < candidateCount; c++) {

            int cx = candidateX[c];
            int cy = candidateY[c];

            int mask = 0;

            for (int h = 0; h < N; h++) {

                int d = manhattan(
                        cx,
                        cy,
                        homes[h].x,
                        homes[h].y
                );

                distance[c][h] = d;

                // 해당 집이 허용하는 거리 안에 있으면 커버 가능
                if (d <= homes[h].limit) {
                    mask |= (1 << h);
                }
            }

            coverMask[c] = mask;
        }

        int fullMask = (1 << N) - 1;

        // ===================================================
        // 3. 충전소 1개로 가능한지 먼저 확인
        // ===================================================

        int oneStationAnswer = INF;

        for (int c = 0; c < candidateCount; c++) {

            // 이 충전소 하나가 모든 집을 커버하는 경우
            if (coverMask[c] != fullMask) {
                continue;
            }

            int sum = 0;

            for (int h = 0; h < N; h++) {
                sum += distance[c][h];
            }

            oneStationAnswer = Math.min(oneStationAnswer, sum);
        }

        /*
         * 문제 조건:
         *
         * 충전소 1개만으로 모든 집을 만족시킬 수 있다면
         * 반드시 1개만 지어야 한다.
         *
         * 따라서 여기서 바로 답을 반환한다.
         */
        if (oneStationAnswer != INF) {
            return oneStationAnswer;
        }

        // ===================================================
        // 4. 1개가 불가능한 경우에만 충전소 2개 탐색
        // ===================================================

        int twoStationAnswer = INF;

        for (int first = 0; first < candidateCount; first++) {

            for (int second = first + 1;
                    second < candidateCount;
                    second++) {

                /*
                 * 두 충전소를 합쳐도
                 * 모든 집을 커버하지 못하면 볼 필요 없음.
                 */
                if ((coverMask[first] | coverMask[second]) != fullMask) {
                    continue;
                }

                int sum = 0;

                // 각 집은 더 가까운 충전소를 이용한다.
                for (int h = 0; h < N; h++) {

                    int nearestDistance =
                            Math.min(
                                    distance[first][h],
                                    distance[second][h]
                            );

                    sum += nearestDistance;

                    // 이미 현재 최솟값보다 커졌다면 더 볼 필요 없음
                    if (sum >= twoStationAnswer) {
                        break;
                    }
                }

                twoStationAnswer =
                        Math.min(twoStationAnswer, sum);
            }
        }

        /*
         * 2개로도 모든 집을 만족시키지 못하면 -1
         */
        return twoStationAnswer == INF
                ? -1
                : twoStationAnswer;
    }

    static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}