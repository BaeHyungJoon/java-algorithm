package programmers.lv2.p72412;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
	
	public int[] solution(String[] info, String[] query) {
    	
        // info에서 지원자 정보를 하나씩 받아올 때 language, domain, career, food로 가능한 조합 전부를 key로 만든다.
		// 해당 key 속성들을 가진 지원자의 코딩테스트 점수들을 배열에 저장한다.
		// key로 만들 때 info에 들어오는 것들만 가지고 String인 key를 만들면 안된다.
		// query에서 해당 속성이 '-'로 들어올 수 있기 때문에, 해당 케이스도 포함해서 key를 만들어야 한다.
		
		Map<String, List<Integer>> applicants = new HashMap<>();
		int[] answer = new int[query.length];
		
		for (String indivInfo : info) {
			
			StringTokenizer st = new StringTokenizer(indivInfo);
			
			String language = st.nextToken();
			String domain = st.nextToken();
			String career = st.nextToken();
			String food = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
		    String[] conditions = {language, domain, career, food};

		    makeKeys(conditions, 0, "", score, applicants);
			
		}
		
		// 지원자의 점수 list를 정렬
		for (List<Integer> scores : applicants.values()) {
			Collections.sort(scores);
		}
		
		// query에서 원하는 조건 받아와서 저장
		for (int i = 0; i < query.length; i++) {
			
			String indivQuery = query[i];
			
			StringTokenizer st = new StringTokenizer(indivQuery);
			
			String language = st.nextToken();
			st.nextToken();
			String domain = st.nextToken();
			st.nextToken();
			String career = st.nextToken();
			st.nextToken();
			String food = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			
			String key = language + " " + domain + " " + career + " " + food;
			
			List<Integer> scores = applicants.get(key);
			
			if (scores == null) {
				answer[i] = 0;
				continue;
			}
			
			int low = 0;
			int high = scores.size();
			
			while (low < high) {
				int mid = (low + high) / 2;
				if (scores.get(mid) >= score) {
					high = mid;
				} else {
					low = mid + 1;
				}
			}
			
			answer[i] = scores.size() - low;
		}

        return answer;
    
    }
	
	// info에서 가져올 때 지원자 정보를 String으로 가져올 때 query에서는 해당 조건을 특정 짓지 않는 경우가 발생할 수 있음
	// 애초에 info에서 
	private void makeKeys(String[] conditions, int depth, String key, int score, Map<String, List<Integer>> applicants) {
		
		// query에서 찾을 때 4가지 조건을 모두 선택한 경우
		if (depth == 4) {
			if (!applicants.containsKey(key)) {
				applicants.put(key, new ArrayList<>());
			}
			
			applicants.get(key).add(score);
			return;
		}
		
		// query에서 찾을 때 4가지 조건 중 -이 포함된 경우
		// case 1. query에서 실제 조건을 사용할 경우
	    String actualKey;

	    if (key.isEmpty()) {
	        actualKey = conditions[depth];
	    } else {
	        actualKey = key + " " + conditions[depth];
	    }

	    makeKeys(conditions, depth + 1, actualKey, score, applicants);

	    //case 2. query에서 해당 조건을 "-"로 사용하는 경우
	    String wildcardKey;

	    if (key.isEmpty()) {
	        wildcardKey = "-";
	    } else {
	        wildcardKey = key + " -";
	    }

	    makeKeys(conditions, depth + 1, wildcardKey, score, applicants);
		
	}

}