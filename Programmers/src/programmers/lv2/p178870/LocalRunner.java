package programmers.lv2.p178870;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		System.out.println("======== Test 1 ========");
		int[] sequence1 = {1,2,3,4,5};
		int k1 = 7;
		int[] result1 = solution.solution(sequence1, k1);
		
		System.out.println("======== Test 2 ========");
		int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
		int k2 = 5;
		int[] result2 = solution.solution(sequence2, k2);
		
		System.out.println("======== Test 3 ========");
		int[] sequence3 = {2, 2, 2, 2, 2};
		int k3 = 6;
		int[] result3 = solution.solution(sequence3, k3);
		
	}

}