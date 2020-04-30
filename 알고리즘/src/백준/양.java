package 백준;

import java.io.*;
import java.util.*;

public class 양 {
	static int R, C, O, V, ocnt, vcnt;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String data = br.readLine();
			map[i] = data.toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '#') {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}

		System.out.println(ocnt + " " + vcnt);
	}

	public static void bfs(int y, int x) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(y, x));
		O = 0;
		V = 0;
		if(map[y][x] == 'v') V++;
		else if(map[y][x] == 'o') O++;
		while (!q.isEmpty()) {
			XY tmp = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = tmp.y + dy[d];
				int nx = tmp.x + dx[d];
				if (ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] != '#' && !visited[ny][nx]) {
					if (map[ny][nx] == 'o') {
						O++;
					}
					if (map[ny][nx] == 'v') {
						V++;
					}
					visited[ny][nx] = true;
					q.add(new XY(ny, nx));
				}
			}
		}
		if (O > V) {
			V = 0;
			ocnt += O;
		} else {
			vcnt += V;
			O = 0;
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
