package swea.d4.p4008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, max, min;
	static int[] operators, numbers;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			
			N = Integer.parseInt(br.readLine());
			
			operators = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operators[i] = Integer.parseInt(st.nextToken());
			}
			
			numbers = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			// =================== 핵심 알고리즘 =====================
			
			// numbers 개수 - 1 만큼의 빈칸에 연산자를 배치할 것
			// 이때 4가지 연산자가 최대 11개 빈칸에 들어갈 수 있는 경우의 수는 약 400만
			// 따라서 이 경우 전체를 재귀 DFS를 통해 완전탐색을 하면 된다.
			// 이 때 가장 핵심 정보는 2가지이다.
			// 1. 지금까지 몇번째 숫자까지 계산했는가?
			// 2. 지금까지 계산한 결과가 얼마인가?
			// dfs를 시작할 때 빈칸은 첫번째 숫자가 등장하고 나오게 됨. 따라서 index는 1부터 시작하고, result도 첫번째 숫자로 시작

			dfs(1, numbers[0]);
			
			// =================== 핵심 알고리즘 =====================
			
			output.append('#').append(testCase).append(' ').append(max - min).append('\n');
			
		}
		
		System.out.print(output);
		
	}
	
	static void dfs (int idx, int result) {
		
		// 종료조건(기저조건)
		if (idx == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		// 현재 사용할 수 있는 연산자들을 하나씩 확인한다.
		// 하나를 선택하고, numbers[idx]와 계산한다.
		// 다음 숫자로 이동한다.
		
		for (int op = 0; op < 4; op++) {
			
			if (operators[op] == 0) {
				continue;
			}
			
			int nextResult = result;
			
			if (op == 0) {
				nextResult = result + numbers[idx];
			} else if (op == 1) {
				nextResult = result - numbers[idx];
			} else if (op == 2) {
				nextResult = result * numbers[idx];
			} else {
				nextResult = result / numbers[idx];
			}
			
			operators[op]--;
			
			dfs(idx+1, nextResult);
			
			operators[op]++;
			
		}
		
	}
	
}