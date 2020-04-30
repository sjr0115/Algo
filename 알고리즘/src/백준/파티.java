package 백준;

import java.io.*;
import java.util.*;

public class 파티 {
	static ArrayList<Edge>[] adj;
	static ArrayList<Edge>[] reverseAdj;
	static int[] dist, reverseDist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		dist = new int[V];
		reverseDist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(reverseDist, Integer.MAX_VALUE);
		
		adj = new ArrayList[V];
		reverseAdj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
			reverseAdj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, w));
			reverseAdj[b].add(new Edge(a, w));
		}
		
		dijkstra(adj, dist, X);
		dijkstra(reverseAdj, reverseDist, X);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < V; i++) {
			max = Math.max(max, dist[i] + reverseDist[i]);
		}
		System.out.println(max);
	}

	private static void dijkstra(ArrayList<Edge>[] adj, int[] dist, int X) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(X, dist[X] = 0));
		
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

	static class Edge implements Comparable<Edge> {
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
