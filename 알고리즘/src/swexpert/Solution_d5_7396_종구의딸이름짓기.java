package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d5_7396_종구의딸이름짓기 {
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 1 };
	static int[] dx = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(0, 0, map[0][0] + ""));
			visited[0][0] = true;
			String ans = "";
			while (!pq.isEmpty()) {
				Point p = pq.poll();
				
				if(p.y == N -1 && p.x == M - 1) {
					ans = p.s;
					break;
				}
				
				for (int d = 0; d < 2; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx])
						continue;
					visited[ny][nx] = true;
					pq.add(new Point(ny, nx, p.s + map[ny][nx]));
				} // 출발점에서 거리가 같은 좌표의 탐색이 끝남.
			}
			System.out.println("#" + t + " " + ans);
			pq.clear();
		}
	}

	static class Point implements Comparable<Point> {
		int y;
		int x;
		String s;

		public Point(int y, int x, String s) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
		}

		@Override
		public int compareTo(Point o) {
			return this.s.compareTo(o.s);
		}

	}
}
