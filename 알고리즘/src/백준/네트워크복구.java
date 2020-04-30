package 백준;

import java.io.*;
import java.util.*;

public class 네트워크복구 {
	static ArrayList<Edge>[] adj;
	static int[] dist, ans;
	static int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ans = new int[N + 1];
		dist = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			dist[i] = INF;
		}
		
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}
		
		dijkstrat();
		
		sb.append(N - 1 + "\n");
		for (int i = 1; i <= N; i++) {
			if(ans[i] != 0) {
				sb.append(i + " " + ans[i] + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static void dijkstrat() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curPos = cur.pos;
			int curDist = cur.dist;
			
			if(dist[curPos] < curDist) continue;
			
			for (Edge next : adj[curPos]) {
				int nextPos = next.pos;
				
				if(dist[nextPos] > dist[curPos] + next.dist) {
					dist[nextPos] = dist[curPos] + next.dist;
					pq.add(new Edge(nextPos, dist[nextPos]));
					ans[nextPos] = curPos;
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
			return this.dist - o.dist;
		}
	}
}
