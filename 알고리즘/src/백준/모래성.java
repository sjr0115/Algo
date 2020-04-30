package 백준;

import java.io.*;
import java.util.*;

public class 모래성 {
	static int H, W, ans;
	static int[][] map;
	static int[] dy = { 1, 1, 1, -1, -1, -1, 0, 0 };
	static int[] dx = { 0, 1, -1, 0, 1, -1, 1, -1 };
	static Queue<XY> q = new LinkedList<XY>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			String data = br.readLine();
			for (int j = 0; j < W; j++) {
				if (data.charAt(j) == '.') {
					q.add(new XY(i, j));
				} else {
					map[i][j] = data.charAt(j) - '0';
				}
			}
		}
		bfs();
		System.out.println(ans);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				XY tmp = q.poll();
				for (int d = 0; d < 8; d++) {
					int ny = tmp.y + dy[d];
					int nx = tmp.x + dx[d];
					if (ny >= 0 && nx >= 0 && ny < H && nx < W && map[ny][nx] != 9) {
						map[ny][nx]--;
						
						if(map[ny][nx] == 0) {
							cnt++;
							q.add(new XY(ny, nx));
						}
					}
				}
			}
			if(cnt != 0) {
				ans++;
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
