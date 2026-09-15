package programmers.lv3.p72414;

class Solution {

	public String solution(String play_time, String adv_time, String[] logs) {

		// play_time (HH:MM:SS => HH*3600+MM*60+SS로 숫자 변형) : 배열의 최댓값
		// HH:MM:SS을 HH int형, MM int형, SS int형으로 분할하고 초 계산
		String[] arr = play_time.split(":");
		int HH = Integer.parseInt(arr[0]);
		int MM = Integer.parseInt(arr[1]);
		int SS = Integer.parseInt(arr[2]);
		int totalPlayTime = HH * 3600 + MM * 60 + SS;

		int[] PlayTime = new int[totalPlayTime];
		
		

		String answer = "";
		return answer;

	}

}