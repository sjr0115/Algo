package swexpert;

import java.io.*;
import java.util.StringTokenizer;
 
public class Solution_모의_2105_디저트카페 {
	static int[] dy = {1, 1, -1, -1};
	static int[] dx = {1, -1, -1, 1};
	static int[][] map;
	static boolean[] visited;
	static int N, sy, sx, ans;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					sy = i;
					sx = j;
					visited = new boolean[101];
					dfs(i, j, 0, 1);
				}
			}
			
			sb.append("#" + t + " " + (ans == 0 ? -1 : ans) + "\n");
		}
    	System.out.println(sb.toString());
    }

	private static void dfs(int y, int x, int dir, int cnt) {
		visited[map[y][x]] = true;
		
		for (int d = dir; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(sy == ny && sx == nx && cnt >= 4) {
				if(ans < cnt) {
					ans = cnt;
					return;
				}
			}
			
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[map[ny][nx]]) continue;
			dfs(ny, nx, d, cnt + 1);
		}
		visited[map[y][x]] = false;
	}
  
}