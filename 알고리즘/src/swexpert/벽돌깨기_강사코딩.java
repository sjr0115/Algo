package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class 벽돌깨기_강사코딩 {
	static int N, W, H, ans;
	static int[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int brickCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			brickCnt = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						brickCnt++;
					}
				}
			}
			ans = brickCnt;
			
			dropMarble(N, brickCnt, map);
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dropMarble(int n, int brickCnt, int[][] map) {
		if(n == 0) {
			ans = Math.min(ans, brickCnt);
			return;
		}
		for(int x = 0; x < W; x++) {
			int[][] cloned = cloneMap(map);
			
			Brick first = getFirstBrick(x, cloned);
			if(first == null) continue;
			int broken = crash(first, cloned);
			if(broken >= brickCnt) {
				ans = 0;
				return;
			}
			
			cleanMap(cloned);
			dropMarble(n - 1, brickCnt - broken, cloned);
			
		}
	}

	private static void cleanMap(int[][] map) {
		for (int x = 0; x < W; x++) {
			for(int y = H - 1, ny = H - 1; y >= 0; y--) {
				if(map[y][x] != 0) {
					int temp = map[y][x];
					map[y][x] = 0;
					map[ny--][x] = temp;
				}
			}
		}
	}

	private static int crash(Brick first, int[][] map) {
		int broken = 0;
		map[first.y][first.x] = 0;
		broken++;
		
		for (int p = 1; p < first.pow; p++) {
			
			for(int d = 0; d < 4; d++) {
				int ny = first.y + dy[d] * p;
				int nx = first.x + dx[d] * p;
				if(isIn(ny, nx) && map[ny][nx] != 0) {
					broken += crash(new Brick(ny, nx, map[ny][nx]), map);
				}
			}
		}
		return broken;
	}

	private static boolean isIn(int y, int x) {
		return y >= 0 && x >= 0 && y < H && x < W;
	}

	private static Brick getFirstBrick(int x, int[][] map) {
		for (int y = 0; y < H; y++) {
			if(map[y][x] != 0) {
				return new Brick(y, x, map[y][x]);
			}
		}
		return null;
	}

	private static int[][] cloneMap(int[][] map) {
		int[][] temp = new int[H][W];
		for (int i = 0; i < H; i++) {
			temp[i] = map[i].clone();
		}
		return temp;
	}


	static class Brick {
		int y;
		int x;
		int pow;
		public Brick(int y, int x, int pow) {
			super();
			this.y = y;
			this.x = x;
			this.pow = pow;
		}
		
	}
}
