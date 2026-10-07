package programmers.lv3.p118669;

import java.util.Arrays;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		System.out.println("================ Test 1 ================");
		int n1 = 6;
		int[][] paths1 = {{1,2,3}, {2,3,5}, {2,4,2}, {2,5,4}, {3,4,4}, {4,5,3}, {4,6,1}, {5,6,1}};
		int[] gates1 = {1, 3};
		int[] summits1 = {5};
		int[] answer1 = solution.solution(n1, paths1, gates1, summits1);
		System.out.println("예상 출력 : [5, 3]");
		System.out.println("실제 출력 : " + Arrays.toString(answer1));
		
		System.out.println("================ Test 2 ================");
		int n2 = 7;
		int[][] paths2 = {{1,4,4}, {1,6,1}, {1,7,3}, {2,5,2}, {3,7,4}, {5,6,6}};
		int[] gates2 = {1};
		int[] summits2 = {2, 3, 4};
		int[] answer2 = solution.solution(n2, paths2, gates2, summits2);
		System.out.println("예상 출력 : [3, 4]");
		System.out.println("실제 출력 : " + Arrays.toString(answer2));
		
		System.out.println("================ Test 3 ================");
		int n3 = 7;
		int[][] paths3 = {{1,2,5}, {1,4,1}, {2,3,1}, {2,6,7}, {4,5,1}, {5,6,1}, {6,7,1}};
		int[] gates3 = {3, 7};
		int[] summits3 = {1, 5};
		int[] answer3 = solution.solution(n3, paths3, gates3, summits3);
		System.out.println("예상 출력 : [5, 1]");
		System.out.println("실제 출력 : " + Arrays.toString(answer3));
		
		System.out.println("================ Test 4 ================");
		int n4 = 5;
		int[][] paths4 = {{1,3,10}, {1,4,20}, {2,3,4}, {2,4,6}, {3,5,20}, {4,5,6}};
		int[] gates4 = {1, 2};
		int[] summits4 = {5};
		int[] answer4 = solution.solution(n4, paths4, gates4, summits4);
		System.out.println("예상 출력 : [5, 6]");
		System.out.println("실제 출력 : " + Arrays.toString(answer4));
		
	}

}
