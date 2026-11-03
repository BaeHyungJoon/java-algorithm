package swea.d4.p4040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			String str = new String(br.readLine());
			
			int answer = 1;

			// 반복 단위 A의 길이를 1부터 증가시키며 탐색
			for (int i = 1; i <= str.length(); i++) {

			    // 전체 문자열 길이가 반복 단위 길이로 나누어떨어져야 함
			    if (str.length() % i != 0) {
			        continue;
			    }

			    boolean isValid = true;

			    // i칸 떨어진 문자끼리 비교하여 반복 패턴 확인
			    for (int j = 0; j < str.length() - i; j++) {

			        // 문자가 하나라도 다르면 현재 반복 단위는 유효하지 않음
			        if (str.charAt(j) != str.charAt(j + i)) {
			            isValid = false;
			            break;
			        }
			    }

			    // 가장 짧은 유효 반복 단위를 찾았다면 반복 횟수 계산
			    if (isValid) {
			        answer = str.length() / i;
			        break;
			    }
			}
			
			output.append('#').append(testCase).append(' ').append(answer).append('\n');
			
		}
		
		System.out.print(output);
		
	}

}