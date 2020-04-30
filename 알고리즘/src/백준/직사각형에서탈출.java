package 백준;

import java.io.*;
import java.util.*;

public class 직사각형에서탈출 {
	static int x, y, w, h, min;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[w + 1][h + 1];
		visited = new boolean[w + 1][h + 1];
		
		for (int i = 0; i <= w; i++) {
			for (int j = 0; j <= h; j++) {
				if((i == w && j == h) || i == 0 || i == w || j == h || j == 0) {
					map[i][j] = 1;
				}
			}
		}
		min = Integer.MAX_VALUE;
		bfs(x, y);
		System.out.println(min);
	}
	private static void bfs(int sx, int sy) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(sx, sy, 0));
		visited[sx][sy] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			if(map[cur.x][cur.y] == 1) {
				min = Math.min(min, cur.dist);
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(nx < 0 || ny < 0 || nx > w || ny > h) continue;
				if(visited[nx][ny]) continue;
				visited[nx][ny] = true;
				q.add(new Point(nx, ny, cur.dist + 1));
			}
		}
	}
	
	static class Point {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
}
