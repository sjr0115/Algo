package 백준;

import java.io.*;
import java.util.*;

public class 최단경로 {
	static int V, E, S;
	static int[] dist;
	static List<Edges>[] adj;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[V + 1];
		visited = new boolean[V + 1];
		S = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<Edges>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edges(v, w));
		}
		
		dijkstra();
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<Edges> pq = new PriorityQueue<>();
		pq.add(new Edges(S, dist[S] = 0));
		
		while(!pq.isEmpty()) {
			int curPos = pq.poll().pos;
			if(visited[curPos]) continue;
			visited[curPos] = true;
			
			for (Edges next : adj[curPos]) {
				if(dist[next.pos] > dist[curPos] + next.dist) {
					dist[next.pos] = dist[curPos] + next.dist;
					pq.add(new Edges(next.pos, dist[next.pos]));
				}
			}
		}
	}

	static class Edges implements Comparable<Edges>{
		int pos, dist;

		public Edges(int pos, int dist) {
			super();
			this.pos = pos;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edges o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
}
