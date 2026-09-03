package swea.d3.p1873;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		
		int T = Integer.parseInt(br.readLine()); // 전체 테스트 케이스
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 초기 게임 맵의 row 개수
			int W = Integer.parseInt(st.nextToken()); // 초기 게임 맵의 col 개수
			char[][] map = new char[H][W]; //초기 게임 맵
			// 초기 게임 맵에서 전차 위치 세팅
			int tankRow = 0;
			int tankCol = 0;
			
			// 초기 게임 맵 및 전차 위치 세팅
			for (int row = 0; row < H; row++) {
				
				String line = br.readLine();
				
				for (int col = 0; col < W; col++) {
					map[row][col] = line.charAt(col);
					if (map[row][col] == '^' || map[row][col] == 'v' || map[row][col] == '<' || map[row][col] == '>') {
						tankRow = row;
						tankCol = col;
					}
					
				}
			}
			
			int N = Integer.parseInt(br.readLine()); // 전차 동작 횟수
			String commands = br.readLine(); // 전차 동작 문자열
			
			// ============= <핵심 메커니즘> =============

			for (int i = 0; i < N; i++) {
				
				char command = commands.charAt(i);
				
				// 전차 포탄 발사하는 경우
				if (command == 'S') {
					
					int bombdr = 0;
					int bombdc = 0;
					
					char tankDirection = map[tankRow][tankCol];
					
					switch (tankDirection) {
						
						case '^':
							bombdr = -1;
							bombdc = 0;
							break;
						
						case 'v':
							bombdr = 1;
							bombdc = 0;
							break;
							
						case '<':
							bombdr = 0;
							bombdc = -1;
							break;
						
						case '>':
							bombdr = 0;
							bombdc = 1;
							break;
							
					}
					
					int bombRow = tankRow + bombdr;
					int bombCol = tankCol + bombdc;
					
					while (bombRow >= 0 && bombRow < H && bombCol >= 0 && bombCol < W) {
						
						if (map[bombRow][bombCol] == '*') {
							map[bombRow][bombCol] = '.';
							break;
						}
						
						if (map[bombRow][bombCol] == '#') {
							break;
						}
						
						bombRow += bombdr;
						bombCol += bombdc;
						
					}
					
				} else { // 전차 이동하는 경우
					
					int dr = 0;
					int dc = 0;
					char tankDirection = ' ';
					 
                    switch (command) {

                    	case 'U':
                    		dr = -1;
                    		dc = 0;
                    		tankDirection = '^';
                    		break;

                    	case 'D':
                    		dr = 1;
                    		dc = 0;
                    		tankDirection = 'v';
                    		break;

                    	case 'L':
                    		dr = 0;
                    		dc = -1;
                    		tankDirection = '<';
                    		break;

                    	case 'R':
                    		dr = 0;
                    		dc = 1;
                    		tankDirection = '>';
                    		break;
                    		
					}
				
                    map[tankRow][tankCol] = tankDirection;
                    
                    int nextRow = tankRow + dr;
                    int nextCol = tankCol + dc;
                    
                    if (nextRow >= 0 && nextRow < H && nextCol >= 0 && nextCol < W && map[nextRow][nextCol] == '.') {
                    	
                    	map[tankRow][tankCol] = '.';
                    	
                    	tankRow = nextRow;
                    	tankCol = nextCol;
                    	
                    	map[tankRow][tankCol] = tankDirection;
                    	
                    }
				}
			}
			
			// ============= <핵심 메커니즘> =============
			
			output.append("#").append(testCase).append(" ");
			
			for (int row = 0; row < H; row++) {
			    for (int col = 0; col < W; col++) {
			        output.append(map[row][col]);
			    }
			    output.append('\n');
			}
			
		}
		
		System.out.println(output);
		
	}

}