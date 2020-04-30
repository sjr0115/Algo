package 알골강의;

import java.util.LinkedList;
import java.util.Queue;

public class bfs활용 {
	static int[][] map = new int[3][3];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {

		bfs1();
		bfs2();
		bfs3();
	}

	private static void bfs3() {
		boolean[][] visited = new boolean[3][3];

		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point front = q.poll();
				System.out.println(front);

				for (int d = 0; d < 4; d++) {
					int nr = front.row + dirs[d][0];
					int nc = front.col + dirs[d][1];
					if (isIn(nr, nc)) {
						if (!visited[nr][nc]) {
							visited[nr][nc] = true;
							q.add(new Point(nr, nc, front.depth + 1));
						}
					}
				}

			}
		}
		
	}

	private static void bfs2() {
		boolean[][] visited = new boolean[3][3];

		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point front = q.poll();
				System.out.println(front);

				for (int d = 0; d < 4; d++) {
					int nr = front.row + dirs[d][0];
					int nc = front.col + dirs[d][1];
					if (isIn(nr, nc)) {
						if (!visited[nr][nc]) {
							visited[nr][nc] = true;
							q.add(new Point(nr, nc, front.depth + 1));
						}
					}
				}

			}
		}

	}

	private static void bfs1() {
		boolean[][] visited = new boolean[3][3];

		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Point front = q.poll();
			System.out.println(front);

			for (int d = 0; d < 4; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				if (isIn(nr, nc)) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Point(nr, nc, front.depth + 1));
					}
				}
			}

		}
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < 3 && c < 3;
	}

	static class Point {
		int row, col, depth;

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}
	}
}
