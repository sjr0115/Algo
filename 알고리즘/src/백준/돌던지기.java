package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 돌던지기 {

	static int R;
	static int C;
	static char[][] map;
	static int[] volcano;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];

			for (int i = 0; i < R; i++) {
				String s = br.readLine().replace(" ", "");
				map[i] = s.toCharArray();
			}

			int K = Integer.parseInt(br.readLine());
			volcano = new int[K];
			for (int i = 0; i < K; i++) {
				volcano[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 0; i < K; i++) {
				int c = volcano[i] - 1;
				move(0, c);
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

	}

	static void move(int r, int c) {
		for (int j = r; j < R; j++) {
			
			if (map[j][c] == '.') {
				if (j == R - 1) {
					map[j][c] = 'O';
					return;
				} else {
					continue;
				}
			} else if (map[j][c] == 'X') {
				map[j - 1][c] = 'O';
				return;
			} else if (map[j][c] == 'O') {
				if (0 <= j - 1 && 0 <= c - 1 && map[j - 1][c - 1] == '.' && map[j][c - 1] == '.') {
					move(j - 1, c - 1);
					return;
				} else if (0 <= j - 1 && c + 1 < C && map[j - 1][c + 1] == '.' && map[j][c + 1] == '.') {
					move(j - 1, c + 1);
					return;
				} else {
					map[j - 1][c] = 'O';
					return;
				}
			}
		}
	
	}
}
