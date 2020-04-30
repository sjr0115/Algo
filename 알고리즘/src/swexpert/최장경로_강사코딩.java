package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class 최장경로_강사코딩 {
	static int N, M;
	static int[][] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adj = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1;
				adj[b][a] = 1;
				
			}
			for(int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static boolean[] visited;
	static int ans = 0;
	static void dfs(int v, int cnt) {
		//더 이상 방문할 노드가 없음 : 기저파
		// cnt가 가장 큰 값
		ans = Math.max(ans, cnt);
		//모든 노드 중에서 나와 간선이 존재하고, 아직 방문하지 않은 노드라면 방문
		for (int i = 1; i <= N; i++) {
			if(adj[v][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
