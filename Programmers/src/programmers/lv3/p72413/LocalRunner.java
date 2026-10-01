package programmers.lv3.p72413;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		System.out.println("=============Test 1============");
		int n1 = 6;
		int s1 = 4;
		int a1 = 6;
		int b1 = 2;
		int[][] fares1 = {{4,1,10}, {3,5,24}, {5,6,2}, {3,1,41}, {5,1,24}, {4,6,50}, {2,4,66}, {2,3,22}, {1,6,25}};
		int answer1 = solution.solution(n1, s1, a1, b1, fares1);
		System.out.println("예상 결과 : 82");
		System.out.println("실제 결과 : " + answer1);
		
		System.out.println("=============Test 2============");
		int n2 = 7;
		int s2 = 3;
		int a2 = 4;
		int b2 = 1;
		int[][] fares2 = {{5,7,9}, {4,6,4}, {3,6,1}, {3,2,3}, {2,1,6}};
		int answer2 = solution.solution(n2, s2, a2, b2, fares2);
		System.out.println("예상 결과 : 14");
		System.out.println("실제 결과 : " + answer2);
		
		System.out.println("=============Test 3============");
		int n3 = 7;
		int s3 = 3;
		int a3 = 4;
		int b3 = 1;
		int[][] fares3 = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
		int answer3 = solution.solution(n3, s3, a3, b3, fares3);
		System.out.println("예상 결과 : 18");
		System.out.println("실제 결과 : " + answer3);
	}

}