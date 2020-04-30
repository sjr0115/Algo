package 백준;

import java.io.*;
import java.util.*;

public class 숨바꼭질 {
	static ArrayList<Integer>[] adj;
	static int N, M;
	static int dist[];
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			dist[i] = INF;
		}
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}
		
		dijkstra();
		
		int num = 1;
		int cnt = 1;
		int cost = 0;
		for (int i = 2; i <= N; i++) {
			if(cost < dist[i]) {
				num = i;
				cost = dist[i];
				cnt = 1;
			} else if(cost == dist[i]) {
				cnt++;
			}
		}
		System.out.println(num + " " + cost + " " + cnt);
	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curPos = cur.pos;
			int curDist = cur.dist;
			
			if(dist[curPos] < curDist) continue;
			
			for (Integer next : adj[curPos]) {
				if(dist[next] > dist[curPos] + 1) {
					dist[next] = dist[curPos] + 1;
					pq.add(new Edge(next, dist[next]));
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
			return this.dist - o.dist;
		}
	}
}
