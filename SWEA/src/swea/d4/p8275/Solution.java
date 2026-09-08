package swea.d4.p8275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N; // 햄스터 우리 개수
	static int X; // 햄스터 우리 별 최대 햄스터 수
	static int M; // 경근이가 남긴 햄스터 수 기록 개수
	
	static int[][] records; // 경근이의 기록 저장
	
	static int[] current; // 현재 만들고 있는 햄스터 배치
	static int[] best; // 지금까지 찾은 최적 배치
	static int bestTotal; // 지금까지 찾은 최대 햄스터 수

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			records = new int[M][3];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				records[i][0] = Integer.parseInt(st.nextToken()); // I (햄스터 우리 시작)
				records[i][1] = Integer.parseInt(st.nextToken()); // r (햄스터 우리 끝)
				records[i][2] = Integer.parseInt(st.nextToken()); // s (I ~ r 우리 안에 있는 햄스터 수)
			}
			
			current = new int[N];  // 현재 햄스터 배치
			best = new int[N];  // 최적의 햄스터 배치
			bestTotal = -1;  // 아직 가능한 배치 발견 못했다는 뜻
			
			// 완전 탐색 시작
			dfs(0, 0);
			
			output.append('#').append(testCase).append(' ');
			
			if (bestTotal == -1) {
				output.append(-1);
			} else {
				for (int i = 0; i < N; i++) {
					output.append(best[i]).append(' ');
				}
			}
			
			output.append('\n');
			
		}
		
		System.out.print(output);
	}
	
	static void dfs(int idx, int total) {
		
		// 모든 우리의 햄스터 수를 결정
		if (idx == N) {
			
			// 기록을 만족하지 않는 배치는 버린다.
			if(!isValid()) {
				return;
			}
			
			// 더 많은 햄스터를 가진 배치를 발견
			if (total > bestTotal) {
				bestTotal = total;
				
				// 현재 배열을 정답 배열에 복사
				best = current.clone();
			}
			
			return;
			
		}
		
        // 현재 우리에 0 ~ X마리를 하나씩 넣어본다.
        for (int count = 0; count <= X; count++) {

            current[idx] = count;

            // 다음 우리 결정
            dfs(idx + 1, total + count);
        }
        
	}
	
	static boolean isValid() {
		
        // 모든 기록 검사
        for (int i = 0; i < M; i++) {

            int l = records[i][0] - 1;
            int r = records[i][1] - 1;
            int s = records[i][2];

            int sum = 0;

            for (int j = l; j <= r; j++) {
                sum += current[j];
            }

            if (sum != s) {
                return false;
            }
        }
		
		return true;
		
	}

}