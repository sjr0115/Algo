package 백준;

import java.io.*;
import java.util.*;

public class 나무재테크 {
	static int N, M, K, x, y, z;
	static int[][] map, nutrient;
	static int[] dy = { 1, 1, 1, -1, -1, -1, 0, 0 };
	static int[] dx = { 0, 1, -1, 0, 1, -1, 1, -1 };
	static PriorityQueue<Point> tree = new PriorityQueue<Point>();
	static Queue<Point> dead = new LinkedList<Point>();
	static Queue<Point> alive = new LinkedList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		nutrient = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nutrient[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken());
			tree.add(new Point(x, y, z));
		}
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}

		System.out.println(tree.size());
	}

	private static void spring() {
		while (!tree.isEmpty()) {
			Point cur = tree.poll();
			if (map[cur.x][cur.y] >= cur.age) {
				map[cur.x][cur.y] -= cur.age;
				cur.age++;
				alive.add(cur);
			} else {
				dead.add(cur);
			}

		}
	}

	private static void summer() {
		while(!dead.isEmpty()) {
			Point treedead = dead.poll();
			map[treedead.x][treedead.y] += (treedead.age / 2);
		}
	}

	private static void fall() {
		while(!alive.isEmpty()) {
			Point cur = alive.poll();
			if (cur.age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					tree.add(new Point(nx, ny, 1));
				}
			}
			tree.add(cur);
		}
	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += nutrient[i][j];
			}
		}
	}

	static class Point implements Comparable<Point> {
		int x, y, age;

		public Point(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Point o) {
			return this.age - o.age;
		}
	}
}
