package swea.모의SW역량테스트.p5648;

/*
 * <강사님 문제 접근 방식>
 * - 두개 이상 원자 (문제 정확히 읽고 기억하기)
 * - 시간의 흐름에 따른 시뮬레이션처럼 보인다.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Atom {

		int x;
		int y;
		int dir;
		int energy;

		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			int N = Integer.parseInt(br.readLine());

			// Atom 객체를 저장하는 리스트
			List<Atom> atoms = new ArrayList<>();

			// Atom 객체들의 좌표와 방향 에너지 입력받기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				// atoms 리스트에 atom 객체를 넣기
				// 좌표 거리가 홀수일 때는 0.5초 단위에서 충돌하는 경우가 발생하기 때문에 좌표를 모두 2배씩 늘려서 저장
				atoms.add(new Atom(x * 2, y * 2, dir, energy));
			}

			// 방출 에너지 저장 변수
			int result = 0;

			while (atoms.size() >= 2) {
				
				// 원자들이 1초에 1만큼의 거리를 계속 이동하면서 충돌하면 에너지 방출 후 소멸하고, 아예 충돌 안하는 원자들은 고려 안함
				// Map => key : 좌표 값을 하나의 숫자로 표현, value : 해당 좌표에 위치하는 원자 개수
				HashMap<Integer, Integer> count = new HashMap<>();
				// 파악해야 되는 원자들만 따로 임시로 모으는 리스트
				List<Atom> temp = new ArrayList<>();
				// 충돌 되었는지 파악하고 살아남은 원자들 저장 리스트
				List<Atom> nextAtoms = new ArrayList<>();
				
				// 한 턴 (모든 원자를 이동시키고, 이동된 좌표를 저장하기)
				for (Atom atom : atoms) {

					// 1. 모든 원자를 이동시키기
					atom.x += dx[atom.dir];
					atom.y += dy[atom.dir];

					// 이 때 원자를 이동시키는 좌표 범위 바깥으로 이동하는 원자들은 파악 안해도 됨.
					if (atom.x < -2000 || atom.x > 2000 || atom.y < -2000 || atom.y > 2000)
						continue;

					// 파악해야 되는 원자들만 따로 모으기
					temp.add(atom);

					// 2. 이동했을 때 같은 좌표에 원자가 몇 개 있어야 하는지 파악하기
					int key = getKey(atom.x, atom.y);
					count.put(key, count.getOrDefault(key, 0) + 1);

				}

				// 현재 남아 있는 원자들이 좌표가 겹칠 경우 소멸시키고 방출 에너지 합하기
				for (Atom atom : temp) {

					int key = getKey(atom.x, atom.y);

					if (count.get(key) >= 2) {
						result += atom.energy;
					} else {
						nextAtoms.add(atom);
					}

				}

				// 1회 이동 후 충돌 확인한 다음 살아남은 원자들끼리 다시 이동
				atoms = nextAtoms;
				
			}

			output.append('#').append(testCase).append(' ').append(result).append('\n');

		}

		System.out.print(output);

	}

	// 좌표 값 x,y를 하나의 정수로 변환하는 메서드
	// x의 기존 범위 : -1000 ~ 1000 -> 0.5초 단위 충돌을 방지하기 위해 x의 좌표를 2배 늘림 -> -2000 ~ 2000
	static int getKey(int x, int y) {
		return (x + 2000) * 4001 + (y + 2000);
	}

}