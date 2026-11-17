package programmers.lv3.p64064;

import java.util.*;

class Solution {

    String[] user_id;
    String[] banned_id;

    boolean[] visited;
    Set<Integer> result;

    public int solution(String[] user_id, String[] banned_id) {

        this.user_id = user_id;
        this.banned_id = banned_id;

        visited = new boolean[user_id.length];
        result = new HashSet<>();

        dfs(0);

        return result.size();
    }

    // depth: 현재 검사할 banned_id의 인덱스
    private void dfs(int depth) {

        // 모든 불량 사용자 패턴에 사용자를 배정한 경우
        if (depth == banned_id.length) {

            // 선택된 사용자 목록을 비트마스크로 표현
            int mask = 0;

            for (int i = 0; i < user_id.length; i++) {
                if (visited[i]) {
                    mask |= (1 << i);
                }
            }

            // 동일한 사용자 집합은 중복 저장되지 않음
            result.add(mask);
            return;
        }

        // 현재 banned_id에 대응할 사용자 탐색
        for (int i = 0; i < user_id.length; i++) {

            // 이미 선택한 사용자라면 건너뛰기
            if (visited[i]) {
                continue;
            }

            // 현재 불량 사용자 패턴과 일치하지 않으면 건너뛰기
            if (!isMatch(user_id[i], banned_id[depth])) {
                continue;
            }

            // 1. 사용자 선택
            visited[i] = true;

            // 2. 다음 불량 사용자 패턴 탐색
            dfs(depth + 1);

            // 3. 이전 상태로 복원 (백트래킹)
            visited[i] = false;
        }
    }

    // 사용자 ID와 불량 사용자 패턴이 일치하는지 확인
    private boolean isMatch(String user, String banned) {

        if (user.length() != banned.length()) {
            return false;
        }

        for (int i = 0; i < user.length(); i++) {

            // '*'는 모든 문자와 일치
            if (banned.charAt(i) == '*') {
                continue;
            }

            // 문자가 다르면 매칭 실패
            if (user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
