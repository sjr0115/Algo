package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리_Prim {
	static int V, E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int[] key = new int[V + 1];
		int[] p = new int[V + 1];
		int[][] adj = new int[V + 1][V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[u][v] = c;
			adj[v][u] = c;
		}
		
		boolean[] check = new boolean[V + 1];
		Arrays.fill(key, Integer.MAX_VALUE);
		p[1] = -1;
		key[1] = 0;
		for (int i = 0; i < V - 1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 1; j <= V; j++) {
				if(!check[j] && key[j] < min) {
					min = key[j];
					idx = j;
				}
			}
			check[idx] = true;
			
			for (int j = 1; j <= V; j++) {
				if(!check[j] && adj[idx][j] != 0 && adj[idx][j] < key[j]) {
					key[j] = adj[idx][j];
					p[j] = idx;
				}
			}
		}
		long ans = 0;
		for (int i = 1; i <= V; i++) {
			ans += key[i];
		}
		System.out.println(ans);
	}

}
