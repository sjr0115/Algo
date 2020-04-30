package 백준;

import java.io.*;
import java.util.*;

public class 빙산 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] water;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		water = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						visited[i][j] = true;
						bfs(i, j); 
						count++;
					}
				}
			}

			if (count == 0) {
				System.out.println(0);
				break;
			} else if (count >= 2) {
				System.out.println(year);
				break;
			}
			melt();
			year++;
		}
	}

	public static void bfs(int y, int x) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(y, x));
		while (!q.isEmpty()) {
			XY tmp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = tmp.y + dy[d];
				int nx = tmp.x + dx[d];
				if (ny >= 0 && nx >= 0 && ny < N && nx < M) {
					if (map[ny][nx] == 0) {
						water[tmp.y][tmp.x]++;
					}
					if (map[ny][nx] != 0 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						q.add(new XY(ny, nx));
					}
				}
			}

		}
	}

	public static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					map[i][j] -= water[i][j];
					
					if (map[i][j] < 0) {
						map[i][j] = 0;
					}
					
					visited[i][j] = false;
					water[i][j] = 0;
				}
			}
		}
	}

	public static class XY {
		int y;
		int x;

		public XY(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
