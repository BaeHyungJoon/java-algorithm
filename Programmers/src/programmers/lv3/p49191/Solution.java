package programmers.lv3.p49191;

class Solution {
	
    public int solution(int n, int[][] results) {
    	
    	boolean[][] match = new boolean[n+1][n+1];
    	
    	// results에서 하나씩 빼서 match에서 이기는 경우 match에 True 처리
    	for (int[] result : results) {
    		match[result[0]][result[1]] = true;
    	}
    	
    	
        // 승패 관계
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (match[i][k] && match[k][j]) {
                        match[i][j] = true;
                    }
                }
            }
        }
        
        // match 배열 확인
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((match[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        
        // match에서 true, false인 부분만 보고 어떻게 순위 예측이 가능한 선수 수를 return 할 것인가?
        
    	
    	int answer = 0;
        return answer;
    
    }

}