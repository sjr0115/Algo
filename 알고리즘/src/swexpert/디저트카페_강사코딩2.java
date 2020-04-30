package swexpert;

import java.io.*;
import java.util.*;

public class 디저트카페_강사코딩2 {
	static int N; // 맵크기
	static int max; // 디저트를 먹은 최대 개수
	static int sr; // 시작 좌표
	static int sc; // 시작 좌표
	static int[][] map;
	static boolean[] visited;
//								   우하   ->   좌하   ->    좌상   ->   우상
	static int[][] direction = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
//			max를 0으로 초기화
			max = 0;
//			N을 입력 받아 N * N 배열을 생성
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
//			N * N boolean 타입의 visited 배열을 생성
			visited = new boolean[101];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			N * N 반복을 돌면서 i j번째의 카페부터 투어
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
//					시작좌표를 i j 설정
					sr = i;
					sc = j;
					Arrays.fill(visited, false);
					dfs(i, j, 0, 1);
				}
			}
			System.out.println("#" + t + " " + (max == 0 ? -1 : max));
		}
	}

	private static void dfs(int y, int x, int dir, int cnt) {
		visited[map[y][x]] = true;

		for (int d = dir; d < 4; d++) {
			int ny = y + direction[d][0];
			int nx = x + direction[d][1];

			if (ny == sr && nx == sc && cnt >= 4) {
				if (cnt > max) {
					max = cnt;
					return;
				}
			}

			if (ny > -1 && ny < N && nx > -1 && nx < N && !visited[map[ny][nx]]) {
				dfs(ny, nx, d, cnt + 1);
			}
		}
		visited[map[y][x]] = false;
	}

}
