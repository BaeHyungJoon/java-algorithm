package swea.d3.p3260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger n1 = new BigInteger(st.nextToken());
			BigInteger n2 = new BigInteger(st.nextToken());
			BigInteger result = n1.add(n2);
			sb.append("#").append(tc).append(" ").append(result).append('\n');
		}
		System.out.println(sb);
	}
}