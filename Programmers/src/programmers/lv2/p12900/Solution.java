package programmers.lv2.p12900;

class Solution {
    
	public int solution(int n) {
    	
		int[] tiles = new int[n+1];
		
		if (n <= 2) {
			return n;
		} else {
			tiles[n] = tiles[n-1] + tiles[n-2];
			tiles[n] = tiles[n] % 1_000_000_007;
		}
		
        int answer = tiles[n];
        
        return answer;
    
	}

}