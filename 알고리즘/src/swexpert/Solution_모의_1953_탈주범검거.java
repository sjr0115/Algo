package swexpert;

import java.io.*;
import java.util.*;

public class Solution_모의_1953_탈주범검거 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int N, M, R, C, L, cnt;
	static boolean[][] pipe = {
            {true, true, true, true},   //1 상하좌우 
            {true, false, true, false}, //2 상하
            {false, true, false, true}, //3 좌우
            {true, true, false, false}, //4 상우
            {false, true, true, false}, //5 하우
            {false, false, true, true}, //6 하좌
            {true, false, false, true}  //7 상좌
    };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			cnt = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C);
			System.out.println("#" + t + " " + cnt);
		}
	}

	private static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		visited[y][x] = true;

		while (L-- > 0) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				Point cur = q.poll();
				int curY = cur.y;
				int curX = cur.x;
				int type = map[curY][curX] - 1;
				cnt++;
				
				for (int d = 0; d < 4; d++) {
					int ny = curY + dy[d];
					int nx = curX + dx[d];
					
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0) continue;
					if(!pipe[type][d] || visited[ny][nx]) continue;
					int nextType = map[ny][nx] - 1;
					
					if(pipe[nextType][(d + 2) % 4]) {
						visited[ny][nx] = true;
						q.add(new Point(ny, nx));
					}
				}
			}
			
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
