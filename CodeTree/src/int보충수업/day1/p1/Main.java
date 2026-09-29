package int보충수업.day1.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int j = a; j <= b; j++) {
				arr[j]++;
			}
		}
		
		int maxValue = 0;
		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] > maxValue) {
//				maxValue = arr[i];
//			}
			maxValue = Math.max(maxValue, arr[i]);
		}
		
		System.out.println(maxValue);
		
	}

}
