package 과제;

import java.io.*;
import java.util.*;

public class 모의고사_대전_05_서정렬 {
	static int[][] map;
	static int[] dy = {1, 1, 1, -1, -1, -1, 0, 0};
	static int[] dx = {0, 1, -1, 0, 1, -1, 1, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			map = new int[10][10];
			visited = new boolean[10][10];
			
			for (int i = 0; i < 10; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 10; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						ans++;
					}
				}
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= 10 || nx >= 10) continue;
				if(map[ny][nx] != 1 || visited[ny][nx]) continue;
				visited[ny][nx] = true;
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
