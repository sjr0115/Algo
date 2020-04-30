package 백준;

import java.io.*;
import java.util.*;

public class 특정한최단경로 {
	static ArrayList<Edge>[] adj;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		dist = new int[3][N];
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()) - 1;
		int v2 = Integer.parseInt(st.nextToken()) - 1;
		
		dijkstra(0, 0);
		dijkstra(v1, 1);
		dijkstra(v2, 2);
		
		int way1 = dist[0][v1] + dist[1][v2] + dist[2][N - 1];
		int way2 = dist[0][v2] + dist[2][v1] + dist[1][N - 1];
		
		if(dist[0][N - 1] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(way1 > way2 ? way2 : way1);
	}

	private static void dijkstra(int start, int idx) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, dist[idx][start] = 0));
		
		while(!pq.isEmpty()) {
			int curPos = pq.poll().pos;
			
			for (Edge next : adj[curPos]) {
				if(dist[idx][next.pos] > dist[idx][curPos] + next.dist) {
					dist[idx][next.pos] = dist[idx][curPos] + next.dist;
					pq.add(new Edge(next.pos, dist[idx][curPos]));
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
