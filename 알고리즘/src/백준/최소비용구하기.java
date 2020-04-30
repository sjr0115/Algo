package 백준;

import java.io.*;
import java.util.*;

public class 최소비용구하기 {
	static ArrayList<Edge>[] adj;
	static int[] dist;
	static int S, E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v, w));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dijkstra();
		System.out.println(dist[E]);
	}
	
	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(S, dist[S] = 0));
		while(!pq.isEmpty()) {
			int cur = pq.poll().pos;
			
			for (Edge next : adj[cur]) {
				if(dist[next.pos] > dist[cur] + next.dist) {
					dist[next.pos] = dist[cur] + next.dist;
					pq.add(new Edge(next.pos, dist[next.pos]));
				}
			}
		}
	}

	static class Edge implements Comparable<Edge>{
		int pos, dist;

		public Edge(int pos, int dist) {
			super();
			this.pos = pos;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
}
