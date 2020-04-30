package 백준;

import java.io.*;
import java.util.*;

public class 이분그래프 {

	static int V, E;
	static List<Integer>[] graph;
	static int[] colors;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			colors = new int[V + 1];
			graph = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[v].add(u);
				graph[u].add(v);
			}
			ans = true;
			for (int i = 1; i <= V; i++) {
				if (colors[i] == 0) {
					if (dfs(i, 1)) break;
				}
			}
			System.out.println(ans ? "YES" : "NO");
		}
	}

	private static boolean dfs(int start, int color) {
		colors[start] = color;
		
		for (Integer i : graph[start]) {
			if(colors[i] == color) {
				ans = false;
				return true;
			}
			if(colors[i] == 0) {
				if(dfs(i, -color)) return true;
			}
		}
		return false;
	}

}