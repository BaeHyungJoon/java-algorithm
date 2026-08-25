package programmers.lv3.p87391;

public class LocalRunner {
	public static void main(String[] args) {
		Solution solution = new Solution();
		// =========================
        // Test Case 1
        // =========================
		int n1 = 2;
		int m1 = 2;
		int x1 = 0;
		int y1 = 0;
		
		int[][] queries1 = {
				{2, 1},
				{0, 1},
				{1, 1},
				{0, 1},
				{2, 1}
		};
		
		long expected1 = 4;
        long result1 = solution.solution(n1, m1, x1, y1, queries1);

        System.out.println("Test 1");
        System.out.println("expected = " + expected1);
        System.out.println("result   = " + result1);
        System.out.println(result1 == expected1 ? "PASS" : "FAIL");
        System.out.println();
        
        // =========================
        // Test Case 2
        // =========================
        int n2 = 2;
        int m2 = 5;
        int x2 = 0;
        int y2 = 1;

        int[][] queries2 = {
                {3, 1},
                {2, 2},
                {1, 1},
                {2, 3},
                {0, 1},
                {2, 1}
        };

        long expected2 = 2;
        long result2 = solution.solution(n2, m2, x2, y2, queries2);

        System.out.println("Test 2");
        System.out.println("expected = " + expected2);
        System.out.println("result   = " + result2);
        System.out.println(result2 == expected2 ? "PASS" : "FAIL");
	}
}