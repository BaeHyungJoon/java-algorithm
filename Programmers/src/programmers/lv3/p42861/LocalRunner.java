package programmers.lv3.p42861;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int n = 4;
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		
		int result = solution.solution(n, costs);
		
		System.out.println(result);

	}

}