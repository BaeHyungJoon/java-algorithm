package programmers.lv3.p72413;

class Solution {
	
    public int solution(int n, int s, int a, int b, int[][] fares) {
    	
    	// n : 정점 개수 (3이상 200 이하)
    	// 다익스트라 : (n + (n*(n-1)/2))log(n) -> 40200log(2)
    	// 플로이드워셜 : n^3 -> 8000000
    	// 시간 복잡도 상 두 알고리즘 모두 채택 가능
    	// 하지만 문제에서 s->a, s->b로 갈 때 최단거리가 가능하려면 각자 최단거리를 구해서 더하는 것이 아니라
    	// A와 B가 각각 a,b로 가는 과정에서 어디까지 함께 갈 것인가가 핵심! (택시 요금을 최소화 해야하므로)
    	// S -> K, K -> A, K -> B 비용 세 덩어리가 가장 비용이 작게 나와야 하는데, 어디에서 헤어지는 것이 최적인지 이대로는 알 수 없음
    	// K를 모든 정점이 될 수 있다고 생각하고 모두 확인하면 가능함.
    	
        int answer = 0;
        return answer;
        
    }

}