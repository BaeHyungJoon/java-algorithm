package programmers.lv3.p67259;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		System.out.println("============ TestCase 1 ============");
		int[][] board1 = {
				{0, 0, 0}, {0, 0, 0}, {0, 0, 0}
		};
		int result1 = solution.solution(board1);
		System.out.println(result1);
		
		System.out.println("============ TestCase 2 ============");
		int[][] board2 = {
				{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0},
				{0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0},
				{0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}
		};
		int result2 = solution.solution(board2);
		System.out.println(result2);
		
		System.out.println("============ TestCase 3 ============");
		int[][] board3 = {
				{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0} 
		};
		int result3 = solution.solution(board3);
		System.out.println(result3);
		
		System.out.println("============ TestCase 4 ============");
		int[][] board4 = {
				{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}
		};
		int result4 = solution.solution(board4);
		System.out.println(result4);
		
	}

}
