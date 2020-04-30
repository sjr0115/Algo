package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d4_7699_수지의수지맞는여행 {
	static int R, C, ans;
	static char[][] map;
	static boolean[] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for(int i = 0; i < R; i++) {
				String data = br.readLine();
				map[i] = data.toCharArray();
			}
			visited = new boolean[26];
			ans = Integer.MIN_VALUE;
			visited[map[0][0] - 'A'] = true;
			dfs(0, 0, 1);
			System.out.println("#" + t + " " + ans);
		}
	}
	public static void dfs(int y, int x, int cnt) {
		ans = Math.max(ans, cnt);
		if(cnt == 26) return;
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
			if(visited[map[ny][nx] - 'A']) continue;
			visited[map[ny][nx] - 'A'] = true;
			dfs(ny, nx, cnt + 1);
			visited[map[ny][nx] - 'A'] = false;
		}
	}
}
