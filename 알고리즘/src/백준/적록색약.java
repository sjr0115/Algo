package 백준;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static char[] color = { 66, 71, 82 }; // B, G, R

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			map[i] = data.toCharArray();
		}
		int cnt1, cnt2;
		cnt1 = cnt2 = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					if (!visited[i][j] && color[k] == map[i][j]) {
						visited[i][j] = true;
						bfs(i, j, color[k]);
						cnt1++;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'R') {
					map[i][j] = 'G';
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					if (!visited[i][j] && color[k] == map[i][j]) {
						visited[i][j] = true;
						bfs(i, j, color[k]);
						cnt2++;
					}
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}

	private static void bfs(int y, int x, char cidx) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x, cidx));

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				if (visited[ny][nx])
					continue;
				if (p.colorNum == map[ny][nx]) {
					visited[ny][nx] = true;
					q.add(new Point(ny, nx, p.colorNum));
				}
			}
		}
	}

	static class Point {
		int y;
		int x;
		char colorNum;

		public Point(int y, int x, char colorNum) {
			super();
			this.y = y;
			this.x = x;
			this.colorNum = colorNum;
		}
	}
}
