package swexpert;

import java.io.*;
import java.util.*;

public class Solution_모의_2105_디저트카페 {
	static int N, sy, sx, ans;
	static int[][] map;
	static boolean[] visited;
	static int[] dy = { 1, 1, -1, -1 };
	static int[] dx = { -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new boolean[101];
			ans = -1;
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					sy = i;
					sx = j;
					visited[map[i][j]] = true;
					dfs(i, j, 0);
					visited[map[i][j]] = false;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int y, int x, int dCnt) {
		for (int d = dCnt; d < dCnt + 2 && d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;
			if (sy == ny && sx == nx) {
				int count = 0;
				for (int i = 1; i <= 100; i++) {
					if (visited[i]) {
						count++;
					}
				}
				ans = Math.max(ans, count);
				return;
			}

			if (visited[map[ny][nx]])
				continue;
			visited[map[ny][nx]] = true;
			dfs(ny, nx, d);
			visited[map[ny][nx]] = false;
		}
	}
}