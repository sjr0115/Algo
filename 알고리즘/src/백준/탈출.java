package 백준;

import java.io.*;
import java.util.*;

public class 탈출 {
	static int R, C, sy, sx, wy, wx, time;
	static char[][] map;
	static Queue<Point> sq = new LinkedList<Point>();
	static Queue<Point> wq = new LinkedList<Point>();
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean sucsess;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String data = br.readLine();
			map[i] = data.toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					sy = i;
					sx = j;
					sq.add(new Point(i, j));
				}
				if (map[i][j] == '*') {
					wy = i;
					wx = j;
					wq.add(new Point(i, j));
				}
			}
		}
		bfs();
		
		if(sucsess) {
			System.out.println(time);
		}else {
			System.out.println("KAKTUS");
		}
	}

	public static void bfs() {
		while (!sq.isEmpty()) {
			if(sucsess) break;
			time++;

			int wsize = wq.size();
			for (int i = 0; i < wsize; i++) {
				Point P = wq.poll();
				for (int d = 0; d < 4; d++) {
					int ny = P.y + dy[d];
					int nx = P.x + dx[d];
					if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
						if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
							map[ny][nx] = '*';
							wq.add(new Point(ny, nx));
						}
					}
				}
			}

			int size = sq.size();
			for (int i = 0; i < size; i++) {
				Point P = sq.poll();
				for (int d = 0; d < 4; d++) {
					int ny = P.y + dy[d];
					int nx = P.x + dx[d];
					if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
						if (map[ny][nx] == 'D') {
							sucsess = true;
							return;
						}
						if (map[ny][nx] == '.') {
							map[ny][nx] = 'S';
							sq.add(new Point(ny, nx));
						}
					}
				}
			}
		}
	}

	public static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
