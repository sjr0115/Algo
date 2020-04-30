package 백준;

import java.io.*;
import java.util.*;

public class 보물섬 {
	static int L, W, max;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[L][W];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < L; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				visited = new boolean[L][W];
				if(map[i][j] == 'L') {
					bfs(i, j, 0);
				}
			}
		}
		System.out.println(max);
	}
	private static void bfs(int y, int x, int hour) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x, hour));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			visited[p.y][p.x] = true;
			if(max < p.dist) {
				max = p.dist;
			}
			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= L || nx >= W) continue;
				if(map[ny][nx] == 'W' || visited[ny][nx]) continue;
				int np = p.dist + 1;
				visited[ny][nx] = true;
				q.add(new Point(ny, nx, np));
			}
		}
	}
	
	static class Point {
		int y, x, dist;

		public Point(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
}
