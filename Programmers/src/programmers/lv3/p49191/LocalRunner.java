package programmers.lv3.p49191;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		int answer = solution.solution(n, results);
		
		System.out.println("예상 return = 2");
		System.out.println("실제 return = " + answer);
		
	}

}