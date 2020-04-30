package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_모의_5656_벽돌꺠기 {
	static int N, W, H, wallCnt, ans;
	static int[][] map;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			wallCnt = 0;
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						wallCnt++;
					}
				}
			}
			ans = wallCnt;
			dfs(N, wallCnt, map);
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int n, int wallCnt, int[][] map) {
		if(n == 0) {
			ans = Math.min(ans, wallCnt);
			return;
		}
		
		for (int x = 0; x < W; x++) {
			int[][] copy = new int[H][W];
			for (int y = 0; y < H; y++) {
				copy[y] = map[y].clone();
			}
			
			Point Wall = null;
			for (int y = 0; y < H; y++) {
				if(copy[y][x] != 0) {
					Wall = new Point(y, x, copy[y][x]);
					break;
				}
			}
			if(Wall == null) continue;
			
			int broken = crash(Wall, copy);
			if(broken >= wallCnt) {
				ans = 0;
				return;
			}
			chageMap(copy);
			dfs(n - 1, wallCnt - broken, copy);
		}
	}

	private static void chageMap(int[][] copy) {
		for(int x = 0; x < W; x++) {
			for(int y = H - 1, ny = H - 1; y >= 0; y--) {
				if(copy[y][x] != 0) {
					int temp = copy[y][x];
					copy[y][x] = 0;
					copy[ny--][x] = temp;
				}
			}
		}
	}

	private static int crash(Point wall, int[][] copy) {
		int broken = 0;
		copy[wall.y][wall.x] = 0;
		broken++;
		
		for(int p = 1; p < wall.pow; p++) {
			for(int d = 0; d < 4; d++) {
				int ny = wall.y + dy[d] * p;
				int nx = wall.x + dx[d] * p;
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || copy[ny][nx] == 0) continue;
				broken += crash(new Point(ny, nx, copy[ny][nx]), copy);
			}
		}
		return broken;
	}


	static class Point {
		int y;
		int x;
		int pow;
		public Point(int y, int x, int pow) {
			super();
			this.y = y;
			this.x = x;
			this.pow = pow;
		}
	}
}
