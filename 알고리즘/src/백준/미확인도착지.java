package 백준;

import java.io.*;
import java.util.*;

public class 미확인도착지 {
	static ArrayList<Edge>[] adj;
	static int[] dist;
	static int n, m, t, s, g, h;
	static ArrayList<Integer> ans;
	static boolean[] check;
	static final int INF = 10000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[n + 1];
			dist = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				adj[i] = new ArrayList<>();
				dist[i] = INF;
			}
			check = new boolean[n + 1];
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if((a == g && b == h) ||(a == h && b == g)) {
					d = (2 * d) - 1;
				} else {
					d *= 2;
				}
				adj[a].add(new Edge(b, d));
				adj[b].add(new Edge(a, d));
			}
			
			ans = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				int x = Integer.parseInt(br.readLine());
				ans.add(x);
			}
			
			dijkstra();
			
			Collections.sort(ans);
			for (Integer num : ans) {
				if(dist[num] % 2 == 1) {
					bw.write(num + " ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(s, dist[s] = 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curPos = cur.pos;
			
			if(check[curPos]) continue;
			check[curPos] = true;
			
			for (Edge next : adj[curPos]) {
				int nextPos = next.pos;
				int nextDist = next.dist;
				if(dist[nextPos] > dist[curPos] + nextDist) {
					dist[nextPos] = dist[curPos] + nextDist;
					pq.add(new Edge(nextPos, dist[nextPos]));
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
