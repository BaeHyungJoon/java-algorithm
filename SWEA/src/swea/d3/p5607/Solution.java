package swea.d3.p5607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final long MOD = 1234567891;
	static long[] fact = new long[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		fact[0] = 1;
		for (int i = 1; i <= 1000000; i++) {
			fact[i] = (fact[i - 1] * i) % MOD;
		}

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long a = fact[N];
			long b = (fact[R] * fact[N - R]) % MOD;
			long inverse = pow(b, MOD - 2);;
			
			long answer = (a * inverse) % MOD;

			output.append('#').append(tc).append(' ').append(answer).append('\n');

		}

		System.out.print(output);

	}
	
	// 빠른 거듭제곱 O(log exp)
    static long pow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp /= 2;
        }

        return result;
    }

}