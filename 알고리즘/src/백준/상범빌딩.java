package 백준;

import java.io.*;
import java.util.*;

public class 상범빌딩 {
	static int L, R, C, cnt;
	static char[][][] map;
	static boolean[][][] visited;
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0, 0, 0};
	static int[] dx = {0, 0, 1, -1, 0 ,0};
	static boolean success;
	static Queue<Point> q = new LinkedList<Point>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0) break;
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					map[i][j] = br.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						if(map[i][j][k] == 'S') {
							q.add(new Point(i, j, k, 0));
							visited[i][j][k] = true;
						}
					}
				}
				br.readLine();
			}
			cnt = 0;
			success = false;
			bfs();
			
			if(success) {
				System.out.println("Escaped in " + cnt + " minute(s).");
			} else {
				System.out.println("Trapped!");
			}
			q.clear();
		}
		
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Point cur = q.poll();
			if(map[cur.z][cur.y][cur.x] == 'E') {
				success = true;
				cnt = cur.cnt;
				return;
			}
			for (int d = 0; d < 6; d++) {
				int nz = cur.z + dz[d];
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if(nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C) continue;
				if(visited[nz][ny][nx] || map[nz][ny][nx] == '#') continue;
				visited[nz][ny][nx] = true;
				q.add(new Point(nz, ny, nx, cur.cnt + 1));
			}
		}
	}
	static class Point {
		int z, y, x, cnt;

		public Point(int z, int y, int x, int cnt) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
