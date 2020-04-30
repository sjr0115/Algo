package 백준;

import java.io.*;
import java.util.*;

public class 비숍 {
	static int N;
	static int[][] map;
	static int[] dy = { -1, -1 };
	static int[] dx = { -1, 1 };
	static boolean[][] visited, colors;
	static int[] res = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		colors = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				colors[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0);
			}
		}
		solve(-1, true, 0);
		solve(-1, false, 0);
		System.out.println(res[0] + res[1]);
	}

	public static void solve(int idx, boolean black, int cnt) {
		for (int i = idx + 1; i < N * N; i++) {
			int y = i / N;
			int x = i % N;

			if (map[y][x] != 0 && colors[y][x] == black && check(y, x)) {
				visited[y][x] = true;
				solve(i, black, cnt + 1);
				visited[y][x] = false;
			}
		}
		res[black ? 1 : 0] = Math.max(res[black ? 1 : 0], cnt);
	}

	public static boolean check(int y, int x) {
		for (int i = 0; i < 2; i++) {
			int ny = y;
			int nx = x;
			while (true) {
				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					break;
				if (visited[ny][nx])
					return false;
				ny += dy[i];
				nx += dx[i];
			}

		}
		return true;

	}
}
