package 백준;

import java.io.*;
import java.util.*;

public class 거의최단경로 {
	static int[][] map;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Integer>[] list;
	static int N, M, S, D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			map = new int[N][N];
			dist = new int[N];
			Arrays.fill(dist, INF);
			list = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
				Arrays.fill(map[i], -1);
			}
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				map[u][v] = p;
			}
			
			dijkstra();
			tracedel();
			Arrays.fill(dist, INF);
			sb.append(dijkstra() + "\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void tracedel() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(D);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (Integer pre : list[cur]) {
				if(map[pre][cur] != -1 && dist[cur] == dist[pre] + map[pre][cur]) {
					q.add(pre);
					map[pre][cur] = -1;
				}
			}
		}
	}

	private static int dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(S, dist[S] = 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curPos = cur.pos;
			int curDist = cur.dist;
			
			if(dist[curPos] < curDist) continue;
			
			for (int next = 0; next < N; next++) {
				if(map[curPos][next] != -1 && dist[next] >= dist[curPos] + map[curPos][next]) {
					dist[next] = dist[curPos] + map[curPos][next];
					pq.add(new Edge(next, dist[next]));
					list[next].add(curPos);
				}
			}
		}
		return dist[D] >= INF ? -1 : dist[D];
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