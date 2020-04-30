package 백준;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리_크루스칼3 {
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] adj = new int[V + 1][3];
		parents = new int[V + 1];
		PriorityQueue<Edges> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Edges(u, v, c));
		}
		
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		
		int cnt = 0;
		long ans = 0;
		while(cnt != V - 1) {
			Edges e = pq.poll();
			int x = e.x;
			int y = e.y;
			if(findSet(x) == findSet(y)) continue;
			union(x, y);
			ans += e.dist;
			cnt++;
		}
		System.out.println(ans);
	}
	
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		parents[py] = px;
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

	static class Edges implements Comparable<Edges> {
		int x, y;
		long dist;
		public Edges(int x, int y, long dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edges o) {
			return Long.compare(this.dist, o.dist);
		}
	}
}