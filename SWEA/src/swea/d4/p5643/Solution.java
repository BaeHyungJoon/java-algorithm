package swea.d4.p5643;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            boolean[][] reach = new boolean[N + 1][N + 1];

            // 1. 직접적인 키 비교 관계 저장
            for (int m = 0; m < M; m++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                reach[a][b] = true;
            }

            // 2. 플로이드-워셜: 간접적인 키 비교 관계 파악
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    if (!reach[i][k]) continue;
                    for (int j = 1; j <= N; j++) {
                        if (reach[k][j]) {
                            reach[i][j] = true;
                        }
                    }
                }
            }

            // 3. 순위를 정확히 아는 학생 수 계산
            int answer = 0;

            for (int i = 1; i <= N; i++) {
                int count = 0;

                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;

                    if (reach[i][j] || reach[j][i]) {
                        count++;
                    }
                }

                if (count == N - 1) {
                    answer++;
                }
            }

            output.append("#").append(tc).append(" ").append(answer).append("\n");
            
        }

        System.out.print(output);
    }
    
}