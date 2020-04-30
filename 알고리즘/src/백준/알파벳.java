package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 알파벳 {
	static int R, C, ans, cnt;
	static char[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = (char) (map[i][j] - 'A');
			}
		}
		
		ans = Integer.MIN_VALUE;
		visited[map[0][0]] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}
	private static void dfs(int y, int x, int cnt) {
		ans = Math.max(ans, cnt);
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(ny < 0 || nx < 0 || ny >= R || nx >= C || visited[map[ny][nx]]) continue;
			visited[map[ny][nx]] = true;
			dfs(ny, nx, cnt + 1);
			visited[map[ny][nx]] = false;
 		}
	}

}
