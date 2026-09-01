package swea.d3.p1225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<Integer> instack = new ArrayDeque<>();
			Deque<Integer> outstack = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				instack.push(Integer.parseInt(st.nextToken()));
			}
			
			boolean finished = false;
			while (!finished) {
				for (int minus = 1; minus <= 5; minus++) {
					if (outstack.isEmpty()) {
						while (!instack.isEmpty()) {
							outstack.push(instack.pop());
						}
					}
					int value = outstack.pop() - minus;
					
					if (value <= 0) {
						value = 0;
						instack.push(value);
						finished = true;
						break;
					}
					instack.push(value);
				}
			}
			sb.append("#").append(n).append(" ");

			// 1. outstack에 남아 있는 값부터 출력
			while (!outstack.isEmpty()) {
			    sb.append(outstack.pop()).append(" ");
			}

			// 2. instack은 순서가 반대이므로 다시 outstack으로 뒤집기
			while (!instack.isEmpty()) {
			    outstack.push(instack.pop());
			}

			// 3. 뒤집힌 값을 순서대로 출력
			while (!outstack.isEmpty()) {
			    sb.append(outstack.pop()).append(" ");
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}