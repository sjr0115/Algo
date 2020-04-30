package 과제;

import java.io.*;
import java.util.*;

public class hwgraph01_대전_05_서정렬 {
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
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[i][0] = u;
			adj[i][1] = v;
			adj[i][2] = c;
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
		int py = findSet(y);
		int px = findSet(x);
		if(rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
	
	private static int findSet(int x) {
		if(x == parents[x]) {
			return x;
		} else {
			return parents[x] = findSet(parents[x]);
		}
	}
	
	private static void makeSet(int x) {
		parents[x] = x;
	}

}
