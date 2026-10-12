package swea.모의SW역량테스트.p2117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	static int[][] map;

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
			int totalHouse = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
                        totalHouse++;
                    }
				}
			}
			
			int answer = 0;
			
//			for (int K = 1; K <= N + 1; K++) {
//
//			    int cost = K * K + (K - 1) * (K - 1);
//
//			    for (int r = 0; r < N; r++) {
//			        for (int c = 0; c < N; c++) {
//
//			            int houseCount = 0;
//
//			            for (int i = 0; i < N; i++) {
//			                for (int j = 0; j < N; j++) {
//
//			                    int distance = Math.abs(r - i) + Math.abs(c - j);
//
//			                    if (distance < K && map[i][j] == 1) {
//			                        houseCount++;
//			                    }
//			                }
//			            }
//
//			            int profit = houseCount * M - cost;
//
//			            if (profit >= 0) {
//			                answer = Math.max(answer, houseCount);
//			            }
//			        }
//			    }
//			}
			
			// 모든 중심 좌표 탐색
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    // 거리별 집의 개수
                    int[] distCount = new int[2 * N];

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {

                            if (map[i][j] == 0) continue;

                            int distance =
                                    Math.abs(r - i)
                                  + Math.abs(c - j);

                            distCount[distance]++;
                        }
                    }

                    int houseCount = 0;

                    // K를 증가시키며 집의 개수 누적
                    for (int K = 1; K <= N + 1; K++) {

                        int cost = K * K + (K - 1) * (K - 1);

                        // 모든 집을 포함해도 적자라면 중단
                        if (totalHouse * M < cost) {
                            break;
                        }

                        houseCount += distCount[K - 1];

                        if (houseCount * M >= cost) {
                            answer = Math.max(answer, houseCount);
                        }
                    }
                }
            }
			
			output.append('#').append(testCase).append(' ').append(answer).append('\n');
			
		}
		
		System.out.print(output);
		
	}

}