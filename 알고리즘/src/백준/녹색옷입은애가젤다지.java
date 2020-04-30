package 백준;

import java.io.*;
import java.util.*;

public class 녹색옷입은애가젤다지 {
	static int[][] map, dist;
	static int N;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			dist = new int[N][N];
			cnt++;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(dist[i], INF);
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dijkstra(map);
			sb.append("Problem " + cnt + ": " + dist[N - 1][N - 1] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void dijkstra(int[][] map) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0, 0, map[0][0]));
		dist[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			int y = cur.y;
			int x=  cur.x;
			int cost = cur.dist;
			
			if(dist[y][x] < cost) continue;
			
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(dist[ny][nx] > dist[y][x] + map[ny][nx]) {
					dist[ny][nx] = dist[y][x] + map[ny][nx];
					pq.add(new Point(ny, nx, dist[ny][nx]));
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int y, x, dist;

		public Point(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}
		
	}
}
