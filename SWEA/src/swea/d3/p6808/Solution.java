package swea.d3.p6808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
    // DFS에서도 사용해야 하므로 static 필드로 선언
    static int[] gyuCards;
    static int[] inCards;
    static boolean[] visited;

    static int winCount;
    static int loseCount;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		// 테스트 케이스 개수
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			gyuCards = new int[9]; // 규영이가 받는 9장의 카드
			boolean[] isGyuCard = new boolean[19]; // 18장 중 규영이가 받은 카드인지 아닌지 확인
			
			// 규영이가 받는 카드 저장 (gyuCards 배열)
			for(int i = 0; i < 9; i++) {
				int gyuCard = Integer.parseInt(st.nextToken());
				gyuCards[i] = gyuCard;
				isGyuCard[gyuCard] = true;
			}
			
			// ============= <핵심 메커니즘> =============
			
			// 규영이는 9장의 카드와 내는 순서도 정해져있음
			// 1~18까지 카드 중에 규영이가 가져간 9개를 제외한 나머지 9개를 인영이가 가짐
			// 인영이는 총 9! 경우의 수로 9장의 카드를 내는 순서를 정할 수 있음
			// 그 중에서 규영이가 이기는 경우와 지는 경우를 구분해야함.
			
			// 인영이가 가진 카드 배열 저장
			inCards = new int[9];
			int index = 0;
			
			for (int card = 1; card <= 18; card++) {
				if (!isGyuCard[card]) {
					inCards[index] = card;
					index++;
				}
			}
			
            // =========================
            // DFS를 위한 초기화
            // =========================

            visited = new boolean[9];

            winCount = 0;
            loseCount = 0;

            // 0라운드, 양쪽 점수 0점부터 시작
            dfs(0, 0, 0);
			
			
			// ============= <핵심 메커니즘> =============
					
			output.append("#").append(testCase).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
			
		}
		
		System.out.println(output);
		
	}

    // 인영이 카드의 모든 순서를 만들어보는 DFS
    static void dfs(int round, int gyuScore, int inScore) {

        // 9장의 카드를 모두 냈다면 게임 한 판 종료
        if (round == 9) {

            if (gyuScore > inScore) {
                winCount++;
            } else {
                loseCount++;
            }

            return;
        }

        // 이번 round에서 인영이가 낼 카드 선택
        for (int i = 0; i < 9; i++) {

            // 이미 앞선 라운드에서 사용한 카드라면 건너뜀
            if (visited[i]) {
                continue;
            }

            // inCards[i]를 이번 라운드에 사용
            visited[i] = true;

            int gyuCard = gyuCards[round];
            int inCard = inCards[i];

            // 규영이 승리
            if (gyuCard > inCard) {

                dfs(
                    round + 1,
                    gyuScore + gyuCard + inCard,
                    inScore
                );

            // 인영이 승리
            } else {

                dfs(
                    round + 1,
                    gyuScore,
                    inScore + gyuCard + inCard
                );
            }

            // 다른 순열에서는 이 카드를 다시 사용할 수 있도록 선택 취소
            visited[i] = false;
        }
    }
	
}