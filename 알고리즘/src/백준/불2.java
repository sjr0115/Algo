package 백준;

import java.io.*;
import java.util.*;

public class 불2 {
	static int R, C, time;
	static char[][] map;
	static Queue<Point> jq = new LinkedList<Point>();
	static Queue<Point> fq = new LinkedList<Point>();
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
				if (map[i][j] == 'J') {
					jq.add(new Point(i, j));
				}
				if (map[i][j] == 'F') {
					fq.add(new Point(i, j));
				}
			}
		}

		solve();

		if (sucsess) {
			System.out.println(time);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

	public static void solve() {
		while (!jq.isEmpty()) {
			time++;
			int fsize = fq.size();
			for (int i = 0; i < fsize; i++) {
				Point p = fq.poll();

				for (int d = 0; d < 4; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
						if (map[ny][nx] == '.' || map[ny][nx] == 'J') {
							map[ny][nx] = 'F';
							fq.add(new Point(ny, nx));
						}
					}
				}
			}

			int jsize = jq.size();
			if(jsize == 0) {
				return;
			}
			for (int i = 0; i < jsize; i++) {
				Point p = jq.poll();

				for (int d = 0; d < 4; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C) {
						sucsess = true;
						return;
					}

					if (map[ny][nx] == '.') {
						map[ny][nx] = 'J';
						jq.add(new Point(ny, nx));
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
