package programmers.lv3.p76503;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		System.out.println("=========== Test 1 ===========");
		int[] a1 = {-5,0,2,1,2};
		int[][] edges1 = {{0,1},{3,4},{2,3},{0,3}};
		long answer1 = solution.solution(a1, edges1);
		System.out.println("예상 정답 : " + answer1);
		System.out.println("실제 정답 : 9");
		
		System.out.println("=========== Test 2 ===========");
		int[] a2 = {0,1,0};
		int[][] edges2 = {{0,1},{1,2}};
		long answer2 = solution.solution(a2, edges2);
		System.out.println("예상 정답 : " + answer2);
		System.out.println("실제 정답 : -1");
		
	}

}