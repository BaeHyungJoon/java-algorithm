package programmers.lv3.p81303;

public class LocalRunner {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int n = 8;
		
		int k = 2;
		
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		
		String result = solution.solution(n, k, cmd);
		String result2 = solution.solution(n, k, cmd2);

        System.out.println(result);
        System.out.println(result2);
	}
}
