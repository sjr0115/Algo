package 백준;

import java.io.*;
import java.util.*;

public class 유기농배추 {
	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(visited[ny][nx] || map[ny][nx] == 0) continue;
				if(map[ny][nx] == 1) {
					visited[ny][nx] = true;
					q.add(new Point(ny, nx));
				}
			}
		}
	}

	public static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
