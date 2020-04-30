package 백준;

import java.io.*;
import java.util.*;

public class 해킹 {
	static ArrayList<Edge>[] adj;
	static int[] dist;
	static int n, d, c, virusCom, INF = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}
			
			dist = new int[n + 1];
			Arrays.fill(dist, INF);
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adj[b].add(new Edge(a, s));
			}
			
			virusCom = 1;
			dijkstra(c);
			
			int[] ans = Arrays.stream(dist).filter(k -> k != INF).toArray();
			Arrays.sort(ans);
			System.out.println(virusCom + " " + ans[ans.length - 1]);
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, dist[start] = 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curPos = cur.pos;
			int curDist = cur.dist;
			
			if(dist[curPos] < curDist) continue;
			
			for (Edge next : adj[curPos]) {
				if(dist[next.pos] > dist[curPos] + next.dist) {
					if(dist[next.pos] == INF) {
						virusCom++;
					}
					dist[next.pos] = dist[curPos] + next.dist;
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
			return this.dist - o.dist;
		}
	}
}
