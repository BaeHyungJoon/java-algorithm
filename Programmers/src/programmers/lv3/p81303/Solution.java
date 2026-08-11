package programmers.lv3.p81303;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public String solution(int n, int k, String[] cmd) {

        // prev[i] : i번 행 바로 위에 존재하는 행 번호
        // next[i] : i번 행 바로 아래에 존재하는 행 번호
        int[] prev = new int[n];
        int[] next = new int[n];

        // 처음에는 0, 1, 2, ..., n-1 순서로 연결되어 있다.
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;

            if (i == n - 1) {
                next[i] = -1;
            } else {
                next[i] = i + 1;
            }
        }

        // 삭제된 행의 정보를 저장한다.
        // 저장 형식:
        // {삭제된 행 번호, 삭제 당시 위쪽 행, 삭제 당시 아래쪽 행}
        Stack<int[]> deletedStack = new Stack<>();

        // 최종 결과 상태
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        // 현재 선택된 행
        int cursor = k;

        for (String command : cmd) {

            char operation = command.charAt(0);

            // 위쪽으로 이동
            if (operation == 'U') {

                int count = Integer.parseInt(command.substring(2));

                for (int i = 0; i < count; i++) {
                    cursor = prev[cursor];
                }

            // 아래쪽으로 이동
            } else if (operation == 'D') {

                int count = Integer.parseInt(command.substring(2));

                for (int i = 0; i < count; i++) {
                    cursor = next[cursor];
                }

            // 현재 행 삭제
            } else if (operation == 'C') {

                int deletedRow = cursor;
                int prevRow = prev[deletedRow];
                int nextRow = next[deletedRow];

                // 복구를 위해 삭제 당시의 연결 정보를 저장한다.
                deletedStack.push(
                    new int[] {deletedRow, prevRow, nextRow}
                );

                answer[deletedRow] = 'X';

                // 위쪽 행이 존재하면 위쪽 행의 next를 수정한다.
                if (prevRow != -1) {
                    next[prevRow] = nextRow;
                }

                // 아래쪽 행이 존재하면 아래쪽 행의 prev를 수정한다.
                if (nextRow != -1) {
                    prev[nextRow] = prevRow;
                }

                // 삭제한 행 아래에 행이 있으면 아래 행을 선택한다.
                if (nextRow != -1) {
                    cursor = nextRow;
                } else {
                    // 삭제한 행이 마지막 행이면 위 행을 선택한다.
                    cursor = prevRow;
                }

            // 가장 최근에 삭제한 행 복구
            } else if (operation == 'Z') {

                int[] restored = deletedStack.pop();

                int restoredRow = restored[0];
                int prevRow = restored[1];
                int nextRow = restored[2];

                answer[restoredRow] = 'O';

                // 복구된 행의 위아래 연결 정보 복원
                prev[restoredRow] = prevRow;
                next[restoredRow] = nextRow;

                // 위쪽 행이 존재하면 위쪽 행과 복구된 행을 연결한다.
                if (prevRow != -1) {
                    next[prevRow] = restoredRow;
                }

                // 아래쪽 행이 존재하면 복구된 행과 아래쪽 행을 연결한다.
                if (nextRow != -1) {
                    prev[nextRow] = restoredRow;
                }

                // cursor는 변경하지 않는다.
            }
        }

        return new String(answer);
    }
}