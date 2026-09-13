package programmers.lv3.p67258;

import java.util.Arrays;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		System.out.println("========= Test 1 ===========");
		String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] result1 = solution.solution(gems1);
		System.out.println(Arrays.toString(result1));
		
		System.out.println("========= Test 2 ===========");
		String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
		int[] result2 = solution.solution(gems2);
		System.out.println(Arrays.toString(result2));
		
		System.out.println("========= Test 3 ===========");
		String[] gems3 = {"XYZ", "XYZ", "XYZ"};
		int[] result3 = solution.solution(gems3);
		System.out.println(Arrays.toString(result3));
		
		System.out.println("========= Test 4 ===========");
		String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		int[] result4 = solution.solution(gems4);
		System.out.println(Arrays.toString(result4));
		
	}

}