package 백준;

import java.io.*;
import java.util.*;

public class 꽃길 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, 1);
		System.out.println(min);
	}

	public static void dfs(int cnt, int sum, int y) {
		if (cnt == 3) {
			min = Math.min(min, sum);
			return;
		}
		for (int i = y; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (visited[i][j] || !check(i, j)) continue;
				visited[i][j] = true;
				int cost = map[i][j];
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					visited[ny][nx] = true;
					cost += map[ny][nx];
				}
				
				dfs(cnt + 1, sum + cost, i);
				
				visited[i][j] = false;
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					visited[ny][nx] = false;
				}
			}
		}
	}

	public static boolean check(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (visited[ny][nx]) {
				return false;
			}
		}
		return true;

	}
}
