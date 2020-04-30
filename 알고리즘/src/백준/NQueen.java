package 백준;

import java.io.*;

public class NQueen {
	static int N, ans;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		dfs(0);
		System.out.println(ans);
	}
	public static void dfs(int y) {
		if(y == N) {
			ans++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(check(y, i)) {
				visited[y][i] = true;
				dfs(y + 1);
				visited[y][i] = false;
			}
		}
	}
	public static boolean check(int y, int x) {
		for(int i = y; i >= 0; i--) {
			if(visited[i][x]) return false;
		}
		
		int ny = y - 1;
		int nx = x - 1;
		while(ny >= 0 && nx >= 0) {
			if(visited[ny--][nx--]) return false;
		}
		
		ny = y - 1;
		nx = x + 1;
		while(ny >= 0 && nx < N) {
			if(visited[ny--][nx++]) return false;
		}
		
		return true;
	}
}
