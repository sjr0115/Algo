package 백준;

import java.io.*;
import java.util.*;

public class 말이되고픈원숭이 {
	static int W, H;
	static int[][] map;
	static int[] dy = { 0, 0, 1, -1, 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dx = { 1, -1, 0, 0, 2, 1, -1, -2, -2, -1, 1, 2 };
	static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i <= K; i++) {
			visited[0][0][K] = true;
		}
		
		System.out.println(bfs(K));
	}

	private static int bfs(int K) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 0));
		int cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				
				if (p.y == H - 1 && p.x == W - 1) {
					return cnt;
				}
				
				for (int d = 0; d < 12; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					
					if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1) continue;
					if(d < 4) {
						if(visited[ny][nx][p.kcnt]) continue;
						visited[ny][nx][p.kcnt] = true;
						q.add(new Point(ny, nx, p.kcnt));
					} else {
						int nk = p.kcnt + 1;
						if(nk > K || visited[ny][nx][nk]) continue;
						visited[ny][nx][nk] = true;
						q.add(new Point(ny, nx, nk));
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	static class Point {
		int y, x, kcnt;

		public Point(int y, int x, int kcnt) {
			super();
			this.y = y;
			this.x = x;
			this.kcnt = kcnt;
		}
	}
}
