package 백준;

import java.io.*;
import java.util.*;

public class 구슬탈출2 {
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[10][10][10][10];
		Point p = new Point();
		for (int i = 0; i < N; i++) {
			String data = br.readLine();
			map[i] = data.toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					p.ry = i;
					p.rx = j;
				}
				if (map[i][j] == 'B') {
					p.by = i;
					p.bx = j;
				}
			}
		}
		bfs(p);
	}

	private static void bfs(Point ball) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(ball);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			visited[p.ry][p.rx][p.by][p.bx] = true;
			
			if(p.cnt >= 10) {
				System.out.println(-1);
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int rNy = p.ry;
				int rNx = p.rx;
				int bNy = p.by;
				int bNx = p.bx;
				
				while(map[bNy + dy[d]][bNx + dx[d]] != '#') {
					bNy += dy[d];
					bNx += dx[d];
					if(map[bNy][bNx] == 'O') {
						break;
					}
				}
				
				while(map[rNy + dy[d]][rNx + dx[d]] != '#') {
					rNy += dy[d];
					rNx += dx[d];
					if(map[rNy][rNx] == 'O') {
						break;
					}
				}
				
				if(map[bNy][bNx] == 'O') continue;
				if(map[rNy][rNx] == 'O') {
					System.out.println(p.cnt + 1);
					return;
				}
				
				if(rNy == bNy && rNx == bNx) {
					switch (d) { // 0 : 동, 1 : 서, 2 : 남, 3 : 북
					case 0:
						if(p.rx > p.bx) {
							bNx -= 1;
						} else {
							rNx -= 1;
						}
						break;
					case 1:
						if(p.rx > p.bx) {
							rNx += 1;
						} else {
							bNx += 1;
						}
						break;
					case 2:
						if(p.ry > p.by) {
							bNy -= 1;
						} else {
							rNy -= 1;
						}
						break;
					case 3:
						if(p.ry > p.by) {
							rNy += 1;
						} else {
							bNy += 1;
						}
						break;
						
					}
					
				}
				if(!visited[rNy][rNx][bNy][bNx]) {
					q.add(new Point(rNy, rNx, bNy, bNx, p.cnt + 1));
				}
			}
		}
		System.out.println(-1);
	}

	static class Point {
		int ry;
		int rx;
		int by;
		int bx;
		int cnt;
		public Point(int ry, int rx, int by, int bx, int cnt) {
			super();
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.cnt = cnt;
		}
		public Point() {}
	}
}
