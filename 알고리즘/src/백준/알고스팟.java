package 백준;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟 {
	static int N, M, ans;
	static int[][] map;
	static int[][] dist;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = data.toString().charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(ans);
	}

	public static void bfs() {
		PriorityQueue<XY> q = new PriorityQueue<XY>();
		q.add(new XY(0, 0, 0));
		dist[0][0] = 0;
		
		while (!q.isEmpty()) {
			XY tmp = q.poll();
			if(tmp.y == N - 1 && tmp.x == M - 1) {
				ans = tmp.cost;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ny = tmp.y + dy[d];
				int nx = tmp.x + dx[d];
				
				if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
					if(dist[ny][nx] > dist[tmp.y][tmp.x] + map[ny][nx]) {
						dist[ny][nx] = dist[tmp.y][tmp.x] + map[ny][nx];
						q.add(new XY(ny, nx, dist[ny][nx]));
					}
				}
			}
		}
	}

	public static class XY implements Comparable<XY> {
		int y;
		int x;
		int cost;
		public XY(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(XY o) {
			return this.cost < o.cost ? -1 : 1;
		}
	}
}
