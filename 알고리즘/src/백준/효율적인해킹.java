package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 효율적인해킹 {
	static ArrayList<Integer>[] ajd;
	static int N, M;
	static boolean[] visited;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ajd = new ArrayList[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			ajd[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			ajd[u].add(v);
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i);
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(dp[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		
		for (int i : ajd[cur]) {
			if(!visited[i]) {
				dp[i]++;
				dfs(i);
			}
		}
		
	}
}
