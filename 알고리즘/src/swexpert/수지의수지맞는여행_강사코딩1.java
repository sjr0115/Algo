package swexpert;

import java.io.*;
import java.util.*;

public class 수지의수지맞는여행_강사코딩1 {
	static int R, C, result;
	static char[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static int[][] v;
	static Set<Character> set = new HashSet();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = 0; // 최대값, 최소값
			set.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			v = new int[R][C];
			for (int i = 0; i < R; i++) {
				String data = br.readLine();
				map[i] = data.toCharArray();
			}
			dfs(1 - 1, 1 - 1, 1);
			System.out.println("#" + t + " " + result);
		}

	}
	static void dfs(int y, int x, int cnt) {
		result = Math.max(result, cnt);
		v[y][x] = 1;
		set.add(map[y][x]);
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
			if(v[ny][nx] == 1) continue;
			//알파벳 중복 체크
			if(set.contains(map[ny][nx])) continue;
			dfs(ny, nx, cnt + 1);
			v[ny][nx] = 0;
			set.remove(map[ny][nx]);
		}
	}
}
