package 백준;

import java.io.*;
import java.util.*;

public class 연구소 {
	static int N, M, max;
	static int[][] map;
	static int[][] copy;
	static Queue<Point> virusList = new LinkedList<Point>();
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Point(i, j));
				}
			}
		}
		max = Integer.MIN_VALUE;
		dfsWall(0, 0);
		System.out.println(max);
	}

	private static void dfsWall(int start, int count) {
		if (count == 3) {
			copyMap();
			for(Point p : virusList) {
				virus(p.y, p.x);
			}

			max = Math.max(max, area());
			return;
		}
		for (int i = start; i < N * M; i++) {
			int y = i / M;
			int x = i % M;

			if (map[y][x] == 0) {
				map[y][x] = 1;
				dfsWall(i + 1, count + 1);
				map[y][x] = 0;
			}
		}
	}

	private static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	private static void virus(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M)
				continue;
			if (copy[ny][nx] == 0) {
				copy[ny][nx] = 2;
				virus(ny, nx);
			}
		}
	}

	private static int area() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
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
