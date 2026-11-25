package programmers.lv2.p118667;

class Solution {
	
	public int solution(int[] queue1, int[] queue2) {
		
		int n = queue1.length; // 각 큐의 초기 원소 개수
		int length = 2 * n;    // 가상 원형 배열의 전체 길이
		
		// 현재 queue1이 차지하는 구간을 [left, right)로 표현
        int left = 0;  // 현재 queue1의 첫 번째 원소 위치
        int right = n; // 현재 queue1의 마지막 원소 바로 다음 위치
		
		long sum = 0L;       // 현재 queue1 구간의 원소 합
		long totalSum = 0L;  // 두 큐의 전체 원소 합
		
		int count = 0;  // 지금까지 수행한 원소 이동 횟수
		
		// 1. 배열을 합치지 않고 원소의 합만 계산
		for (int i = 0; i < n; i++) {
			sum += queue1[i];
			totalSum += (long) queue1[i] + queue2[i];
		}
		
		// 전체 합이 홀수이면 두 큐의 합을 같게 만들 수 없음
		if (totalSum % 2 != 0) {
			return -1;
		}
		
		long target = totalSum / 2;
		
		// 2. 투포인터를 이용한 목표 합 탐색
		while (sum != target) {
			
			// 무한 반복을 방지하기 위한 최대 작업 횟수 필터링
			if (count >= 2 * length) {
				return -1;
			}
			
			if (sum > target) {
				
				// 원형 배열 접근을 위한 나머지 연산
				int index = left % length;
				
				// left가 가리키는 실제 원소를 합에서 제외
				if (index < n) {
					// 가상 배열의 앞쪽 절반은 queue1
					sum -= queue1[index];
				} else {
					// 가상 배열의 뒤쪽 절반은 queue2
					sum -= queue2[index -n];
				}
				// 현재 구간 축소
				left++;
				
			} else {
				
				// 원형 배열 접근을 위한 나머지 연산
				int index = right % length;
				
				// right가 가리키는 실제 원소를 합에 추가
				if (index < n) {
					// 가상 배열의 앞쪽 절반은 queue1
					sum += queue1[index];
				} else {
					// 가상 배열의 뒤쪽 절반은 queue2
					sum += queue2[index - n];
				}
				// 현재 구간 확장
				right++;
			}
			
			count++;
		}
		
		return count;
		
	}
	
}