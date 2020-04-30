package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d5_7793_오나의여신님2 {
	static int N, M;
	static char[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static Queue<Point> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			q = new LinkedList<>();
			Point player = null;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*') {
						q.add(new Point(i, j, 0, true));
					} else if (map[i][j] == 'S') {
						player = new Point(i, j, 0, false);
					}
				}
			}
			q.add(player);
			int ans = Integer.MAX_VALUE;
			loop: while (!q.isEmpty()) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if(p.check) {
						if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
							map[ny][nx] = '*';
							q.add(new Point(ny, nx, p.cost + 1, p.check));
						}
					} else {
						if (map[ny][nx] == 'D') {
							ans = p.cost + 1;
							break loop;
						} else if(map[ny][nx] == '.') {
							map[ny][nx] = 'S';
							q.add(new Point(ny, nx, p.cost + 1, p.check));
						}
						
					}
				}
			}
			System.out.println("#" + t + " " + (ans == Integer.MAX_VALUE ? "GAME OVER" : ans));
		}
	}

	private static class Point {
		int y;
		int x;
		int cost;
		boolean check;

		public Point(int y, int x, int cost, boolean check) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
			this.check = check;
		}
	}
}