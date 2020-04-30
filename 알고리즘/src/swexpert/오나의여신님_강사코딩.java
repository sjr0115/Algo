package swexpert;

import java.io.*;
import java.util.*;

public class 오나의여신님_강사코딩 {

	static StringBuilder sb = new StringBuilder();
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int T, N, M;
	static char[][] map;
	static Queue<Point> devil, player;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			devil = new LinkedList<>();
			player = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*') {
						devil.offer(new Point(i, j, 0));
					} else if (map[i][j] == 'S') {
						player.offer(new Point(i, j, 0));
					}
				}
			}
			while (true) {
				if (player.size() == 0) {
					sb.append("GAME OVER");
					break;
				}
				bfsDevil();
				int result = bfsplayer();
				
				if(result != -1) {
					sb.append(result);
					break;
				}
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int bfsplayer() {
		int size = player.size();

		while (size-- > 0) {
			Point front = player.poll();
			for (int d = 0; d < 4; d++) {
				int ny = front.row + dirs[d][0];
				int nx = front.col + dirs[d][1];
				if (isIn(ny, nx)) {
					if (map[ny][nx] == 'D') {
						return front.depth + 1;
					} else if(map[ny][nx] == '.') {
						map[ny][nx] = 'S';
						player.offer(new Point(ny, nx, front.depth + 1));
					}
				}
			}
		}
		return -1;
	}

	private static void bfsDevil() {
		int size = devil.size();

		while (size-- > 0) {
			Point front = devil.poll();
			for (int d = 0; d < 4; d++) {
				int ny = front.row + dirs[d][0];
				int nx = front.col + dirs[d][1];
				if (isIn(ny, nx)) {
					if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
						map[ny][nx] = '*';
						devil.offer(new Point(ny, nx, front.depth + 1));
					}
				}
			}
		}
	}

	private static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}

	static class Point {
		int row, col, depth;

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}
	}
}
