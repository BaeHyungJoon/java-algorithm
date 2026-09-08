package programmers.lv3.p67259;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
	
    public int solution(int[][] board) {
    	
    	// 경주로 board의 크기
    	int N = board.length;
    	
    	// 경주로 출발 좌표
    	int row = 0;
    	int col = 0;
    	
    	// 방향 이동
    	int[] dr = {-1, 1, 0, 0};
    	int[] dc = {0, 0, -1, 1};
    	
    	Queue<int[]> queue = new ArrayDeque<>();
    	
    	queue.offer(new int[] {row, col});
    	
    	while (!queue.isEmpty()) {
    		
    		int[] current = queue.poll();
    	
    		int r = current[0];
    		int c = current[1];
    		
    		// 현재 좌표에서 상하좌우 다음좌표
        	for (int d = 0; d < 4; d++) {
        		int nextRow = r + dr[d];
            	int nextCol = c + dc[d];
            	
            	if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
            		continue;
            	}
            	
            	if(board[nextRow][nextCol] == 1) {
            		continue;
            	}
            	
            	queue.offer(new int[] {nextRow, nextCol});
            	System.out.println("add queue : " + nextRow + ", " + nextCol);
        	}
    		
    	}
    	
    	int result = 0;
        return result;
    
    }
    
}