package 백준;

import java.io.*;
import java.util.*;

public class 나이트의이동 {
	static int N, sy, sx, ey, ex, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			bfs();
			System.out.println(ans);
		}
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(sy, sx));
		visited[sy][sx] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				Point p = q.poll();
				if(p.y == ey && p.x == ex) {
					ans = cnt;
					return;
				}
				for(int d = 0; d < 8; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
					visited[ny][nx] = true;
					q.add(new Point(ny, nx));
				}
			}
			cnt++;
		}
	}

	static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
