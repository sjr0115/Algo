package 백준;

import java.io.*;
import java.util.*;

public class 최소스패닝트리_크루스칼2 {
	static int V, E;
	static int[] parents, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int[][] adj = new int[E][3];
		parents = new int[V + 1];
		rank = new int[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			adj[i][0] = Integer.parseInt(st.nextToken());
			adj[i][1] = Integer.parseInt(st.nextToken());
			adj[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(adj, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		
		int cnt = 0;
		long ans = 0;
		for (int i = 0; i < E; i++) {
			int u = findSet(adj[i][0]);
			int v = findSet(adj[i][1]);
			if(u == v) continue;
			union(u, v);
			ans += adj[i][2];
			cnt++;
			if(cnt == V - 1) break;
		}
		System.out.println(ans);
	}
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if(rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if(rank[px] == rank[py]) rank[py]++;
		}
	}
	private static int findSet(int x) {
		if(parents[x] == x) {
			return x;
		} else {
			return parents[x] = findSet(parents[x]);
		}
	}
	private static void makeSet(int x) {
		parents[x] = x;
	}
	
}
