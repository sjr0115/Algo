package 백준;

import java.io.*;
import java.util.*;

public class 탈옥 {
	static int h, w;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			char[][] map = new char[h + 2][w + 2];
			int prisony1, prisonx1, prisony2, prisonx2;
			prisony1 = prisonx1 = prisony2 = prisonx2 = -1;
			for (int i = 0; i < h; i++) {
				String data = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i + 1][j + 1] = data.charAt(j);
					if (map[i + 1][j + 1] == '$') {
						if (prisony1 == -1) {
							prisony1 = i + 1;
							prisonx1 = j + 1;
						} else {
							prisony2 = i + 1;
							prisonx2 = j + 1;
						}
					}
				}
			}
			int[][] d0 = bfs(map, 0, 0);
			int[][] d1 = bfs(map, prisony1, prisonx1);
			int[][] d2 = bfs(map, prisony2, prisonx2);
			int ans = Integer.MAX_VALUE;
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] == '*')
						continue;
					int sum = d0[i][j] + d1[i][j] + d2[i][j];
					if (map[i][j] == '#')
						sum -= 2;
					if (ans > sum)
						ans = sum;
				}
			}
			System.out.println(ans);

		}
	}

	private static int[][] bfs(char[][] map, int y, int x) {
		int[][] dist = new int[h + 2][w + 2];
		for (int i = 0; i < h + 2; i++) {
			Arrays.fill(dist[i], -1);
		}
		Deque<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		dist[y][x] = 0;
		while (!q.isEmpty()) {
			Point p = q.remove();

			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if (ny >= 0 && nx >= 0 && ny < h + 2 && nx < w + 2) {
					if(map[ny][nx] != '*' && dist[ny][nx] == -1) {
						if (map[ny][nx] == '#') {
							dist[ny][nx] = dist[p.y][p.x] + 1;
							q.addLast(new Point(ny, nx));
						} else {
							dist[ny][nx] = dist[p.y][p.x];
							q.addFirst(new Point(ny, nx));
						}
						
					}
				}
			}
		}
		return dist;
	}

	private static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
