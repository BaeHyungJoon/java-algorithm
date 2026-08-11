package programmers.lv3.p42628;

import java.util.Arrays;

public class LocalRunner {

	public static void main(String[] args) {
		Solution solution = new Solution();

        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        

		int[] result = solution.solution(operations);
		int[] result2 = solution.solution(operations2);
		

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));

	}

}
