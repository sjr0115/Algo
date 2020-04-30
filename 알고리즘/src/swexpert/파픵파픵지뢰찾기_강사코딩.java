package swexpert;

import java.io.*;

public class 파픵파픵지뢰찾기_강사코딩 {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int[] di = {1, 1, 1, -1, -1, -1, 0, 0};
	static int[] dj = {0, 1, -1, 0, 1, -1, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != '.') continue;
					if(count(i, j) == 0) {
						ans++;
						dfs(i, j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						ans++;
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int i, int j) {
		visit[i][j] = true;
		int mine = count(i, j);
		map[i][j] = (char)(mine + '0');
		if(map[i][j] != '0') return;
		
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni >= 0 && ni < N && nj >= 0 && nj < N 
				&& map[ni][nj] == '.' && !visit[ni][nj]) {
				dfs(ni, nj);
			}
		}
		
	}

	private static int count(int i, int j) {
		int mine = 0;
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] == '*') {
				mine++;
			}
		}
			
		return mine;
	}

}
