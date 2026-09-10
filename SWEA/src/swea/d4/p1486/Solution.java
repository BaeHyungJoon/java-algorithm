package swea.d4.p1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= tc; testCase++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 점원 수
			int B = Integer.parseInt(st.nextToken()); // 선반 높이

			int[] record = new int[N]; // 점원들의 키 저장 int 배열
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				record[i] = Integer.parseInt(st.nextToken()); // 점원들의 키 저장 완료
			}

			// 점원들의 키를 더했을 때 선반 높이보다는 커야하는 경우 중에 가장 낮은 탑의 높이를 만들어야 함.
			// 일단 점원의 키 저장했을 때 이를 정렬해보자.
			Arrays.sort(record);
			int low = 0;
			int high = N - 1;
			int answer = 0;

			while (low <= high) {
				int mid = (low + high) / 2;
				if (totalSum(record, high, mid) < B) {
					high = mid - 1;
					answer = totalSum(record, high, mid);
				} else if(totalSum(record, high, mid) > B) {
					low = mid + 1;
					answer = totalSum(record, high, mid);
				} else {
					answer = 0;
				}
			}

			output.append('#').append(testCase).append(' ').append(answer).append('\n');

		}

		System.out.print(output);

	}

	static int totalSum(int[] record, int n, int mid) {

		int sum = 0;
		for (int i = mid - 1; i <= n - 1; i++) {
			sum += record[i];
		}
		

		return sum;
	}

}