package swea.d3.p3499;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<String> queue = new ArrayDeque<>();
			Queue<String> queue1 = new ArrayDeque<>();
			Queue<String> queue2 = new ArrayDeque<>();
			
			// queue에 입력 집어넣기
			for (int i = 0; i < N; i++) {
			    String value = st.nextToken();
			    queue.offer(value);
			}
			
			// queue 크기 확인 후 반으로 나누기
			// queue의 크기가 홀수이면 절반으로 나누고 queue1에 [n/2]+1개
			// queue의 크기가 짝수이면 절반으로 나눠서 각각 queue1, 2에 저장
			int size = queue.size();
			if (size % 2 == 0) {
				for (int i = 0; i < size/2; i++) {
					String value = queue.poll();
					queue1.offer(value);
				}
			}else {
				for (int i = 0; i < size/2+1; i++) {
					String value = queue.poll();
					queue1.offer(value);
				}
			}
				
			// 이제 queue1에서 하나 빼고, queue에서 하나빼서 queue2에 넣기
			// queue1과 queue가 빌 때까지 번갈아서 queue2에 넣는 방법?
			while (!queue1.isEmpty() || !queue.isEmpty()) {
				
			    if (!queue1.isEmpty()) {
			        queue2.offer(queue1.poll());
			    }

			    if (!queue.isEmpty()) {
			        queue2.offer(queue.poll());
			    }
			}
			
//			if (!queue1.isEmpty()) {
//				queue2.offer(queue1.poll());
//			}
			
			output.append("#").append(testCase).append(" ");
			while(!queue2.isEmpty()) {
				String result = queue2.poll();
				output.append(result).append(" ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}