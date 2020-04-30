package 백준;

import java.io.*;
import java.util.*;

public class 다리만들기 {
	static int N, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int dist = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					map[i][j] = dist;
					bfs(i, j, dist++);
				}
			}
		}

		isBoolean();
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0) {
					bridgeLen(i, j, map[i][j]);
					isBoolean();
				}
			}
		}

		System.out.println(min);

	}

	private static void bridgeLen(int y, int x, int landIdx) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		visited[y][x] = true;
		int cnt = 0;
		boolean sucsess = false;
		loop: while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point land = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int ny = land.y + dy[d];
					int nx = land.x + dx[d];
					
					if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])
						continue;
					if (map[ny][nx] == 0) {
						visited[ny][nx] = true;
						q.add(new Point(ny, nx));
					}
					if (landIdx != map[ny][nx] && map[ny][nx] > 0) {
						sucsess = true;
						break loop;
					}
				}
				
			}
			cnt += 1;
		}
		if(sucsess) {
			if (min > cnt) {
				min = cnt;
			}
		}
	}

	private static void isBoolean() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	private static void bfs(int y, int x, int dist) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));

		while (!q.isEmpty()) {
			Point p = q.poll();
			visited[p.y][p.x] = true;

			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				if (visited[ny][nx] || map[ny][nx] == 0)
					continue;
				visited[ny][nx] = true;
				map[ny][nx] = dist;
				q.add(new Point(ny, nx));
			}
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
