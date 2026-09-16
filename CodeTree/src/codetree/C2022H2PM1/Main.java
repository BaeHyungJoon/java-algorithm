package codetree.C2022H2PM1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * m명의 사람이 베이스 캠프에서 시작해서 가고 싶은 편의점에 다 위치해야 함.
 * 
 * 
 * 
 */

public class Main {

	static int n, m;
	static int[][] map, coordinate;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// nXn 격자 입력 받기 (1: 베이스 캠프, 0: 빈공간)
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// m개의 편의점 좌표 입력 받기
		coordinate = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			coordinate[i][0] = Integer.parseInt(st.nextToken()) - 1;
			coordinate[i][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		
		
		
		
	}

}