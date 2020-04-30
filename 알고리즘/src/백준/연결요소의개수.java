package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수 {
	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	private static void dfs(int v) {
		if(visited[v]) return;
		
		visited[v] = true;
		for (int i : adj[v]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}

}
