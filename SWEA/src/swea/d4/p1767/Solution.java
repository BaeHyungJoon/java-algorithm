package swea.d4.p1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	
	static class Core {
		int r;
		int c;
		
		Core(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] map;
	static ArrayList<Core> cores;
	
	static int maxCore;
	static int minWire;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			cores = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					// map에서 Core일 경우 해당 Core가 가장자리에 위치해서 전선 연결할 필요 없는지 확인
					if (map[i][j] == 1 && i != 0 && i != N -1 && j != 0 && j != N-1) {
						// 전선 연결해야되는 Core들만 저장
						cores.add(new Core(i, j));
					}
				}
			}
			
			maxCore = 0;
			minWire = Integer.MAX_VALUE;
			
			dfs(0,0,0);
			
			output.append('#').append(testCase).append(' ').append(minWire).append('\n');
			
		}
		
		System.out.println(output);
		
	}
	
	static void dfs(int depth, int connected, int wireLength) {
		
		// 종료 조건
		if (depth == cores.size()) {
			
			if (connected > maxCore) {
				maxCore = connected;
				minWire = wireLength;
			} else if (connected == maxCore) {
				minWire = Math.min(minWire, wireLength);
			}
			
			return;
		
		}
		
		Core core = cores.get(depth);
		
		int r = core.r;
		int c = core.c;
		
		for (int d = 0; d < 4; d++) {
			if(!canConnect(r,c,d)) {
				continue;
			}
			int length = setWire(r, c, d, 2);
			
			dfs(depth+1, connected + 1, wireLength + length);
			
			setWire(r, c, d, 0);
		}
		
		dfs(depth+1, connected, wireLength);
	}
	
	static boolean canConnect(int r, int c, int d) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

            if (map[nr][nc] != 0) {
                return false;
            }

            nr += dr[d];
            nc += dc[d];
        }

        return true;
	}
	
	static int setWire(int r, int c, int d, int value) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        int length = 0;

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

            map[nr][nc] = value;
            length++;

            nr += dr[d];
            nc += dc[d];
        }

        return length;
	}
	
}