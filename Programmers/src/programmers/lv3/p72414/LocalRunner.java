package programmers.lv3.p72414;

import java.util.Arrays;

public class LocalRunner {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		System.out.println("======= Test 1 =======");
		String play_time1 = "02:03:55";
		String adv_time1 = "25:00:00";
		String[] logs1 = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		String answer1 = solution.solution(play_time1, adv_time1, logs1);
		System.out.println(answer1);
		
		System.out.println("======= Test 2 =======");
		String play_time2 = "99:59:59";
		String adv_time2 = "25:00:00";
		String[] logs2 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
		String answer2 = solution.solution(play_time2, adv_time2, logs2);
		System.out.println(answer2);
		
		System.out.println("======= Test 3 =======");
		String play_time3 = "50:00:00";
		String adv_time3 = "50:00:00";
		String[] logs3 = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
		String answer3 = solution.solution(play_time3, adv_time3, logs3);
		System.out.println(answer3);
		
	}

}