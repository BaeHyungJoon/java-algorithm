package programmers.lv2.p72412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
	
	public int[] solution(String[] info, String[] query) {
    	
        // info에서 지원자 정보를 하나씩 받아와서 저장한다.
		// 지원자들을 관리하는 자료구조가 필요하다.
		
		Map<String, List<Integer>> applicants = new HashMap<>();
		
		for (String indivInfo : info) {
			
			StringTokenizer st = new StringTokenizer(indivInfo);
			
			String language = st.nextToken();
			String domain = st.nextToken();
			String career = st.nextToken();
			String food = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			String key = language + " " + domain + " " + career + " " + food; 
			
			if (!applicants.containsKey(key)) {
				applicants.put(key, new ArrayList<>());
			}
			
			applicants.get(key).add(score);
			
		}
		
		// query에서 원하는 조건 받아와서 저장
		
		for (String indivQuery : query) {
			
			StringTokenizer st = new StringTokenizer(indivQuery);
			
			String language = st.nextToken();
			st.nextToken();
			String domain = st.nextToken();
			st.nextToken();
			String career = st.nextToken();
			st.nextToken();
			String food = st.nextToken();
			st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			String key = language + " " + domain + " " + career + " " + food;
			
			List<Integer> scores = applicants.get(key);
		
		}
		
		
		
		int[] answer = {};
        return answer;
    
    }

}