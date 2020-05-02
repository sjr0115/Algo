package swexpert;

import java.io.*;
import java.util.*;

public class Solution_모의_1949_등산로조성 {
	static int N, K, max;
	static boolean[][] visited;
	static int[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			max = Integer.MIN_VALUE;
			int hight = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					hight = Math.max(hight, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (hight == map[i][j]) {
						dfs(i, j, false, 1);
					}
				}
			}
			
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int y, int x, boolean check, int cnt) {
		visited[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
			if (map[ny][nx] < map[y][x]) {
				dfs(ny, nx, check, cnt + 1);
			} else {
				if (!check) {
					for (int i = 1; i <= K; i++) {
						if (map[y][x] > map[ny][nx] - i) {
							map[ny][nx] -= i;
							dfs(ny, nx, true, cnt + 1);
							map[ny][nx] += i;
						}
					}
				}
			}
		}
		
		visited[y][x] = false;
		max = Math.max(max, cnt);
	}
	
}
