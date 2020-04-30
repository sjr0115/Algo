package swexpert;

import java.io.*;
import java.util.*;

public class 수지의수지맞는여행_강사코딩2 {
	static int R, C, result;
	static int[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = 0; // 최대값, 최소값
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			v = new int[26];
			for (int i = 0; i < R; i++) {
				String data = br.readLine();
				for(int j = 0; j < C; j++) {
					map[i][j] = data.charAt(j) - 'A';
				}
			}
			dfs(0, 0, 1);
			System.out.println("#" + t + " " + result);
		}

	}
	static void dfs(int y, int x, int cnt) {
		result = Math.max(result, cnt);
		if(cnt == 26) return;
		v[map[y][x]] = 1;
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
			if(v[map[ny][nx]] == 1) continue;
			//알파벳 중복 체크
			dfs(ny, nx, cnt + 1);
			v[map[ny][nx]] = 0;
		}
	}
}
