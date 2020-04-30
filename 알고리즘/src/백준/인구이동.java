package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 인구이동 {
	static int N, L, R, cnt, sum, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static ArrayList<int[]> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new boolean[N][N];
			boolean check = true;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j]) continue;
					arr = new ArrayList<>();
					arr.add(new int[] { i, j });
					sum = map[i][j];
					cnt = 0;

					dfs(i, j);
					
					if (cnt > 1) {
						check = false;
					}
					for (int k = 0; k < arr.size(); k++) {
						map[arr.get(k)[0]][arr.get(k)[1]] = sum / cnt;
					}
				}
			}
			if (check) break;
			ans++;
		}
		System.out.println(ans);
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		cnt++;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
			int dist = Math.abs(map[y][x] - map[ny][nx]);
			if (dist >= L && dist <= R) {
				sum += map[ny][nx];
				arr.add(new int[] { ny, nx });
				dfs(ny, nx);
			}
		}
	}

}
