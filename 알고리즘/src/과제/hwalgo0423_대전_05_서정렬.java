package 과제;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hwalgo0423_대전_05_서정렬 {
	static int N, L, R, c, cnt, sum, ans;
	static int[][] map, copy;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
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
		
		while(true) {
			copy = new int[N][N];
			visited = new boolean[N][N];
			
			c = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(copy[i][j] == 0) {
						arr = new ArrayList<>();
						sum = map[i][j];
						arr.add(new int[] {i, j});
						cnt = 1;
						
						dfs(i, j);
						c++;
						
						if(cnt > 1) {
							for (int k = 0; k < arr.size(); k++) {
								map[arr.get(k)[0]][arr.get(k)[1]] = sum / cnt;
							}
						}
					}
				}
			}
			
			if(--c == N * N) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}

	private static void dfs(int y, int x) {
		copy[y][x] = c;
		visited[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
			int dist = Math.abs(map[y][x] - map[ny][nx]);
			if(dist >= L && dist <= R) {
				cnt++;
				sum += map[ny][nx];
				arr.add(new int[] {ny, nx});
				dfs(ny, nx);
			}
		}
	}

}
