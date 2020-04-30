package swexpert;

import java.io.*;
import java.util.*;

public class 오나의여신님_강사코딩2 {

	static StringBuilder sb = new StringBuilder();
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int T, N, M, A;
	static char[][] map;
	static Queue<Point> points;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = Integer.MAX_VALUE;
			map = new char[N][M];
			points = new LinkedList<>();
			Point player = null;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*') {
						points.add(new Point(i, j, 0, true));
					} else if (map[i][j] == 'S') {
						player = new Point(i, j, 0, false);
					}
				}
			}
			points.add(player);
			
			outer : while (!points.isEmpty()) {
				Point front = points.poll();
				for (int d = 0; d < 4; d++) {
					int ny = front.row + dirs[d][0];
					int nx = front.col + dirs[d][1];
					if (isIn(ny, nx)) {
						if(front.isDevil) {
							if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
								map[ny][nx] = '*';
								points.add(new Point(ny, nx, front.depth + 1, true));
							}
						} else {
							if (map[ny][nx] == 'D') {
								A = front.depth + 1;
								break outer;
							} else if(map[ny][nx] == '.') {
								map[ny][nx] = 'S';
								points.add(new Point(ny, nx, front.depth + 1, false));
							}
							
						}
					}
				}

			}
			sb.append(A == Integer.MAX_VALUE ? "GAME OVER" : A);
			sb.append("\n");
		}
		System.out.println(sb);
	}


	private static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}

	static class Point {
		int row, col, depth;
		boolean isDevil;
		public Point(int row, int col, int depth, boolean isDevil) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.isDevil = isDevil;
		}
	}
}
