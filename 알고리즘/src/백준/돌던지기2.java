package 백준;

import java.io.*;
import java.util.*;

public class 돌던지기2 {
	static int R, C, N;
	static int[] stones;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		N = Integer.parseInt(br.readLine());
		stones = new int[N];

		for (int i = 0; i < N; i++) {
			stones[i] = Integer.parseInt(br.readLine()) - 1;
			bfs(0, stones[i]);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int x, int stone) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, stone));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			int moveY = cur.y;
			int moveX = cur.x;

			if (map[moveY][moveX] == '.') {
				if(moveY == R - 1) {
					map[moveY][moveX] = 'O';
				} else {
					q.add(new Point(moveY + 1, moveX));
				}
			} else if (map[moveY][moveX] == 'X') {
				map[moveY - 1][moveX] = 'O';
			} else if (map[moveY][moveX] == 'O') {
				if (moveY - 1 >= 0 && moveX - 1 >= 0 && map[moveY - 1][moveX - 1] == '.' && map[moveY][moveX - 1] == '.') {
					q.add(new Point(moveY, moveX - 1)); //왼쪽
				} else if (moveY - 1 >= 0 && moveX + 1 < C && map[moveY - 1][moveX + 1] == '.' && map[moveY][moveX + 1] == '.') {
					q.add(new Point(moveY, moveX + 1)); //오른쪽
				} else {
					map[moveY - 1][moveX] = 'O';
				}
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
