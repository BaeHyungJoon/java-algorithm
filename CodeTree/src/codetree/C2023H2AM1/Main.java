package codetree.C2023H2AM1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Knight {

		int r;
		int c;
		int h;
		int w;
		int hp; // 현재 체력
		int initialHp; // 초기 체력 (문제 최종 정답에서 생존한 기사들이 누적된 데미지를 구해야 하기 때문)

		public Knight(int r, int c, int h, int w, int k) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
			this.w = w;
			this.hp = k;
			this.initialHp = k;
		}

	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		// 체스판 입력 (0 : 빈칸 / 1 : 함정 / 2 : 벽)
		int[][] map = new int[L][L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < L; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 기사 정보 입력
		Knight[] knights = new Knight[N + 1];

		// ((r, c) : 좌측 상단 꼭지점 / h : 기사의 세로 길이 / w : 기사의 가로 길이 / k : 기사 초기 체력)
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			knights[i] = new Knight(r, c, h, w, k);
		}

		// 왕의 명령 정보 입력 후 바로바로 시뮬레이션 (이전 명령이 다음 명령에 영향을 끼치기 때문)
		// (i : 기사 번호 / d : 기사가 한 칸 이동하는 방향)
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			moveKnight(i, d, knights, map);
		}

	}
	
	static void moveKnight(int i, int d, Knight[] knights, int[][] map) {
		
	}
	
	static boolean isBlocked(Knight knight, int d, int[][] map) {
		
		int nr = knight.r + dr[d];
		int nc = knight.c + dc[d];
		
		int L = map.length;
		
		for (int i = nr; i < nr + knight.h; i++) {
			for (int j = nc; j < nc + knight.w; j++) {
				if (i < 0 || i >= L || j < 0 || j >= L) {
					return true;
				}
				
				if (map[i][j] == 2) {
					return true;
				}
			}	
		}
		
		return false;
		
	}
	
	static boolean isOverlapping (Knight a, Knight b, int d) {
	
		int nr = a.r + dr[d];
		int nc = a.c + dc[d];
		
		if ((nr+a.h) <= b.r || (nc+a.w) <= b.c) {
			return false;
		}
		if ((n+a.) <= b.r || (nr+a.w) <= b.c) {
			return false;
		}
		
		return true;
	
	}

}