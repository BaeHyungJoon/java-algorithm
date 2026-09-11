package swea.d5.p7206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int[] memo = new int[100000];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder output = new StringBuilder();

		Arrays.fill(memo, -1);

		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {

			int num = Integer.parseInt(br.readLine().trim());

			int result = dfs(num);

			output.append('#').append(testCase).append(' ').append(result).append('\n');
		}

		System.out.print(output);
	}

	// 현재 숫자 n에서 만들 수 있는 최대 turn
	static int dfs(int n) {

		// 한 자리 숫자는 더 이상 쪼갤 수 없음
		if (n < 10) {
			return 0;
		}

		// 이미 계산한 값이면 재사용
		if (memo[n] != -1) {
			return memo[n];
		}

		String s = String.valueOf(n);

		// s를 모든 방법으로 쪼개서 최대 turn 계산
		int maxTurn = split(s, 0, 1, 0);

		memo[n] = maxTurn;

		return maxTurn;
	}

	// 문자열 s를 가능한 모든 방법으로 쪼개기
	static int split(String s, int start, int product, int count) {

		// 문자열 끝까지 조각을 만들었다면
		if (start == s.length()) {

			// 조각이 2개 이상이어야 실제로 쪼갠 것
			if (count >= 2) {
				return 1 + dfs(product);
			}

			// 조각 하나 = 원래 숫자를 안 쪼갠 경우
			return -1;
		}

		int maxTurn = -1;

		int part = 0;

		// 현재 조각의 끝 위치 선택
		for (int end = start; end < s.length(); end++) {

			part = part * 10 + (s.charAt(end) - '0');

			int result = split(s, end + 1, product * part, count + 1);

			maxTurn = Math.max(maxTurn, result);
		}

		return maxTurn;
	}
}