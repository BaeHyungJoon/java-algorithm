package adv보충수업.day1.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int getNum(int k, int n) {
		
		
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 1부터 k이하의 정수
		int N = Integer.parseInt(st.nextToken()); // 1~K 숫자 N번 반복
		
		int answer = getNum(K, N);
		
	}

}