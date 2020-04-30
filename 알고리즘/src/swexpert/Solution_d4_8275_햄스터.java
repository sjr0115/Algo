package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d4_8275_햄스터 {
	static int[] cage; // 가능한 모든 햄스터 배치를 해볼(중복순열)
	static int N, X, M;
	static int[][] input;
	static int max; // 햄스터 배치 여라가지 종류 가능하다면 합이 최대가 되는 경우로 선택
	static String ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = -1;
			ans = "";
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			cage = new int[N + 1]; // 케이지 번호를 1부터 N까지 인덱스로 사용 예정
			input = new int[M][3]; // left, right, sum
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken());
				input[i][1] = Integer.parseInt(st.nextToken());
				input[i][2] = Integer.parseInt(st.nextToken());
			}
			perm(1, 0);
			System.out.println("#" + t + " " + ((max == -1) ? max : ans));
		}
	}

	static void perm(int idx, int sum) { // idx 는 햄스터 케이지 번호.
		if (idx == cage.length) { // 경근이의 체크와 부합하는지 ?!
			if (check()) { // 만족한다?!
				if (max < sum) { // 등호 없는 조건은 ? 똑같은 합계가 나온 사전순 나중에 나온 애는 무시~~~
					max = sum; // 오 합계가 크다 ? 그러면 지금 케이지 순서 일단 저장하자 ~~
					ans = makeAns();
				}
			}
			return;
		}

		for (int i = 0; i <= X; i++) { // 알아서 0부터 채우기 때문에 다음 경우의 수는 점점 커짐!
			cage[idx] = i;
			perm(idx + 1, sum + i);
		}
	}

	static String makeAns() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) { // 1번 케이지부터 ~ N번 케이지까지
			sb.append(cage[i]).append(" ");
		}
		return sb.toString();
	}

	static boolean check() {
		for (int i = 0; i < M; i++) {
			int tmp = 0;
			for (int j = input[i][0]; j <= input[i][1]; j++) { // j => left - figet 까지 돌면서 누적
				tmp += cage[j];

			}
			if (tmp != input[i][2]) {
				return false;
			}
		}
		return true;
	}
}
