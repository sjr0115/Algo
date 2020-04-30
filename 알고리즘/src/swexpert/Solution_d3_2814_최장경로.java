package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d3_2814_최장경로 {
	static int N, M, max;
	static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new boolean[N + 1][N + 1];
			max = Integer.MIN_VALUE;
			for(int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = true;
				map[y][x] = true;
			}
			for(int i = 1; i <= N; i++) {
				dfs(i, 1, new boolean[N + 1]);
			}
			System.out.println("#" + t + " " + max);
		}
	}
	private static void dfs(int v, int len, boolean[] visited) {
		max = Math.max(max, len);
		visited[v] = true;
		for(int i = 1; i <= N; i++) {
			if(i == v || visited[i] || !map[v][i]) continue;
			dfs(i, len + 1, visited);
			visited[i] = false;
		}
	}
	
}
