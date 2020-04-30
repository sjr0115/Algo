package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d5_1907_모래성쌓기 {
	static int H, W, ans;
	static int[][] map;
	static int[] dy = {1, 1, 1, -1, -1, -1, 0, 0};
	static int[] dx = {0, 1, -1, 0, 1, -1, 1, -1};
	static Queue<Point> q = new LinkedList<Point>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for(int i = 0; i < H; i++) {
				String data =br.readLine();
				for(int j = 0; j < W; j++) {
					if(data.charAt(j) == '.') {
						q.add(new Point(i, j));
					} else {
						map[i][j] = data.charAt(j) - '0';
					}
				}
			}
			ans = 0;
			bfs();
			System.out.println("#" + t + " " + ans);
		}
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			int cnt = 0;
			for(int i = 0; i < size; i++) {
				Point p = q.poll();
				for(int d = 0; d < 8; d++) {
					int ny = p.y + dy[d];
					int nx = p.x + dx[d];
					if(ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 9) continue;
					map[ny][nx]--;
					if(map[ny][nx] == 0) {
						cnt++;
						q.add(new Point(ny, nx));
					}
				}
			}
			if(cnt != 0) {
				ans++;
			}
		}
	}
	
	public static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
