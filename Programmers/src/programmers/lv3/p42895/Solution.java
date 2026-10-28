package programmers.lv3.p42895;

import java.util.*;

class Solution {

	public int solution(int N, int number) {

		List<Set<Integer>> dp = new ArrayList<>();

		for (int i = 0; i <= 8; i++) {
			dp.add(new HashSet<Integer>()); // dp[i] -> 숫자 N을 i번 사용해서 만들 수 있는 모든 숫자
		}

		int repeated = 0; // 만들 수 있는 숫자 중에 사칙연산 계산 이외에 숫자를 그대로 이어 붙이는 경우

		for (int count = 1; count <= 8; count++) {
			
			repeated = repeated * 10 + N;
			Set<Integer> current = dp.get(count);
			current.add(repeated);
			
			for (int leftCount = 1; leftCount < count; leftCount++) {
				
				int rightCount = count - leftCount;
				
				for (int a : dp.get(leftCount)) {
					for (int b : dp.get(rightCount)) {
						current.add(a+b);
						current.add(a-b);
						current.add(a*b);
						if (b != 0) {
							current.add(a/b);
						}
					}
				}
			}
			
			if (current.contains(number)) {
				return count;
			}
			
		}

		return -1;

	}

}