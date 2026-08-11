package programmers.lv3.p42627;

public class LocalRunner {

	public static void main(String[] args) {
		Solution solution = new Solution();

        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};

		int result = solution.solution(jobs);

        System.out.println(result);
	}

}
