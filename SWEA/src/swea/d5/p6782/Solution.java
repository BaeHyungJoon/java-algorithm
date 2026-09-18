package swea.d5.p6782;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {

			long n = Long.parseLong(br.readLine());

			/*
			 * ========================= 문제 이해 ========================= <현주의 제곱근 놀이> 2 이상의
			 * 정수 n이 주어졌을 때, n을 n+1로 바꿀 수 있고, sqrt(n)이 정수일 경우에 n을 sqrt(n)으로 바꿀 수 있다.
			 * 
			 * 이 때 n을 2로 만들기 위해서 n을 조작해야하는 횟수의 최솟값을 출력 ========================= 문제 이해
			 * =========================
			 * 
			 * ========================= 아이디어 ========================= n이 주어졌을 때 일단 2이면 바로
			 * 끝. 제곱을 했을 때 정수가 나오는 것이 횟수를 최소화 시키는 것에 핵심인 듯 함. 그럼 현재 n을 제곱했을 때 정수가 나오는 가장 가까운
			 * 수로 바꿔야 한다. 현재 숫자와 가장 가까운 제곱수는 어떻게 찾지? 제곱수일 경우는 더이상 sqrt() 적용했을 때 정수가 안나올 때까지
			 * 진행해보자. 현재 테스트 케이스 중에 99를 한번 계산을 해보면, 일단 제곱수에 가장 가까운 100을 만들기 위해 1회 100에서 루트해서
			 * 10으로 만드는 것 1회, 10에서 다음 제곱수인 16을 만들기 위해 6회, 16을 루트 2번 해서 2 만들기 2회로 총 10회
			 * ========================= 아이디어 =========================
			 */

			// n을 조작해야 하는 횟수 저장
			long result = 0;

			// n이 2가 될때까지 반복해야 함
			while (n != 2) {

//				// n보다 큰 수들 중에서 가장 가까운 제곱수 찾기
//				long sqrtNext = (long) Math.ceil(Math.sqrt(n));
//				long nextSqrtNum = sqrtNext * sqrtNext;
//				
//				if (nextSqrtNum <= n) {
//					sqrtNext++;
//					nextSqrtNum = sqrtNext * sqrtNext;
//				}
//				
//				// 현재 n이 제곱수가 아닐 경우 n보다 큰 수 중에 가장 가까운 제곱수까지 n+1을 진행하기
//				if (Math.sqrt(n) % 1 != 0) {
//					result += nextSqrtNum - n;
//					n = nextSqrtNum;
//				}
//				
//				// 현재 n이 제곱수일 때는 sqrt를 적용하기
//				while (Math.sqrt(n) % 1 == 0) {
//					n = (long) Math.sqrt(n);
//					result++;
//				}

				long sqrt = (long) Math.sqrt(n);

				if (sqrt * sqrt == n) {
					n = sqrt;
					result++;
				}

				else {
					long sqrtNext = sqrt + 1;
					long nextSqrtNum = sqrtNext * sqrtNext;
					
					result += nextSqrtNum - n;
					
					n = nextSqrtNum;
				}

			}

			output.append('#').append(testCase).append(' ').append(result).append('\n');

		}

		System.out.print(output);

	}

}