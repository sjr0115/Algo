package swexpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d4_1868_파핑파픵지뢰찾기 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = { 1, 1, 1, -1, -1, -1, 0, 0 };
	static int[] dx = { 0, 1, -1, 0, 1, -1, 1, -1 };
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int mine = 0;
					if(visited[i][j] || map[i][j] != '.') continue;
					for (int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
						if(map[ny][nx] == '*') {
							mine++;
						}
					}
					
					if(mine == 0) {
						visited[i][j] = true;
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}

	}

	private static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.y][p.x] = 'X';
			int mine = 0;
			for (int d = 0; d < 8; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(map[ny][nx] == '*') {
					mine++;
				}
			}
			
			if(mine == 0) {
				for (int d = 0; d < 8; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					if(visited[ny][nx] || map[ny][nx] != '.') continue;
					visited[ny][nx] = true;
					q.add(new Point(ny, nx));
				}
			}
		}
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
