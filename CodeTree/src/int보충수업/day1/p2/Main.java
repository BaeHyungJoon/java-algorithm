package int보충수업.day1.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[201];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			for (int j = x1+100; j < x2+100; j++) {
				arr[j]++; 
			}
		}
		
		int maxValue = 0;
		for (int i = 0; i < arr.length; i++) {
			maxValue = Math.max(maxValue, arr[i]);
		}
		
		System.out.println(maxValue);
	}

}