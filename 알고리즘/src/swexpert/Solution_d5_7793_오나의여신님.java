package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d5_7793_오나의여신님 {
	static int N, M;
	static char[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static Queue<Point> playerQ, devilQ;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			playerQ = new LinkedList<Point>();
			devilQ = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'S') {
						playerQ.add(new Point(i, j, 0));
					} else if (map[i][j] == '*') {
						devilQ.add(new Point(i, j, 0));
					}
				}
			}
			System.out.print("#" + t + " ");
			while (true) {
				if(playerQ.size() == 0) {
					System.out.println("GAME OVER");
					break;
				}
				devilbfs();
				int ans = playerbfs();
				if (ans != -1) {
					System.out.println(ans);
					break;
				}
			}
		}
	}

	private static void devilbfs() {
		int size = devilQ.size();
		while(size-- > 0) {
			Point p = devilQ.poll();
			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if(map[ny][nx] == '.' || map[ny][nx] == 'S') {
					map[ny][nx] = '*';
					devilQ.add(new Point(ny, nx, p.cost + 1));
				}
			}
		}
	}

	private static int playerbfs() {
		int size = playerQ.size();
		while(size-- > 0) {
			Point p = playerQ.poll();
			for (int d = 0; d < 4; d++) {
				int ny = p.y + dy[d];
				int nx = p.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (map[ny][nx] == 'D') {
					return p.cost + 1;
				} else if(map[ny][nx] == '.') {
					map[ny][nx] = 'S';
					playerQ.add(new Point(ny, nx, p.cost + 1));
				}
			}
		}
		return -1;
		
	}

	private static class Point {
		int y;
		int x;
		int cost;
		public Point(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
}