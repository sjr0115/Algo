package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d4_1226_미로1 {
	static int N, sy, sx, ans;
	static int[][] map;
	static boolean[][] check;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t = 1; t <= T; t++) {
			int K = Integer.parseInt(bf.readLine());
			N = 16;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				String data = bf.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = data.charAt(j) - '0';
					if(map[i][j] == 2) {
						sy = i;
						sx = j;
					}
				}
			}
			ans = 0;
			check = new boolean[N][N];
			bfs(sy, sx);
			System.out.println("#" + t + " " + ans);
		}
	}
	public static void bfs(int y, int x) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(y, x));
		while(!q.isEmpty()) {
			XY tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int ny = tmp.y + dy[d];
				int nx = tmp.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(map[ny][nx] == 0 && !check[ny][nx]) {
					check[ny][nx] = true;
					q.add(new XY(ny, nx));
				}
				if(map[ny][nx] == 3) {
					ans = 1;
					return;
				}
			}
		}
	}
	public static class XY{
		int y;
		int x;
		
		public XY(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
