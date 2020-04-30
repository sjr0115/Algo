package 백준;

import java.io.*;
import java.util.*;

public class 불 {
	static int R, C, time;
	static char[][] map;
	static boolean[][] jcheck;
	static boolean[][] fcheck;
	static Queue<XY> jq = new LinkedList<XY>();
	static Queue<XY> fq = new LinkedList<XY>();
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean sucsess, move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		jcheck = new boolean[R][C];
		fcheck = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String data = br.readLine();
			map[i] = data.toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'J') {
					jq.add(new XY(i, j));
					jcheck[i][j] = true;
				}
				if (map[i][j] == 'F') {
					fq.add(new XY(i, j));
					fcheck[i][j] = true;
				}
			}
		}

		time = 1;
		while (true) {

			if (!fq.isEmpty()) {
				int size = fq.size();
				for (int i = 0; i < size; i++) {
					XY fxy = fq.poll();
					fire(fxy.y, fxy.x);
				}
			}
			if (!jq.isEmpty()) {
				int size = jq.size();
				for (int i = 0; i < size; i++) {
					XY jxy = jq.poll();
					run(jxy.y, jxy.x);
				}
			}
			time++;

			if (sucsess) {
				System.out.println(time);
				break;
			}

			if (jq.isEmpty() && !move && !sucsess) {
				System.out.println("IMPOSSIBLE");
				break;
			}
		}
	}

	public static void fire(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
				if (map[ny][nx] != '#' && !fcheck[ny][nx]) {
					fcheck[ny][nx] = true;
					map[ny][nx] = 'F';
					fq.add(new XY(ny, nx));
				}
			}
		}

	}

	public static void run(int y, int x) {
		if (y == 0 || x == 0 || y == R - 1 || x == C - 1) {
			sucsess = true;
			time--;
			return;
		}
		move = false;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && nx >= 0 && ny < R && nx < C) {
				if (map[ny][nx] != '#' && map[ny][nx] != 'F' && !jcheck[ny][nx]) {
					if (ny == 0 || nx == 0 || ny == R - 1 || nx == C - 1) {
						sucsess = true;
					}
					jcheck[ny][nx] = true;
					move = true;
					map[ny][nx] = 'J';
					jq.add(new XY(ny, nx));
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
