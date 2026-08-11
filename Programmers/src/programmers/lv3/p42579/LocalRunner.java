package programmers.lv3.p42579;

import java.util.Arrays;

public class LocalRunner {
	public static void main(String[] args) {
		Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
		int[] result = solution.solution(genres, plays);
        System.out.println(Arrays.toString(result));
	}
}