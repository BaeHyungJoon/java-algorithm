package programmers.lv3.p64062;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		int result = solution.solution(stones, k);
		System.out.println(result);
		
	}

}