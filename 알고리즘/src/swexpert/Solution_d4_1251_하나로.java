package swexpert;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_d4_1251_하나로 {
	static int[] parents;
	static int[][] adj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			adj = new int[N][2];
			parents = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				adj[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				adj[i][1] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			PriorityQueue<Edges> pq = new PriorityQueue<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					pq.add(new Edges(i, j, (long) (Math.pow(adj[i][0] - adj[j][0], 2) + Math.pow(adj[i][1] - adj[j][1], 2))));
				}
			}
			
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			
			long ans = 0;
			int cnt = 0;
			while(cnt != N - 1) {
				Edges edges = pq.poll();
				int x = edges.x;
				int y = edges.y;
				if(findSet(x) == findSet(y)) continue;
				union(x, y);
				ans += edges.dist;
				cnt++;
			}
			System.out.println("#" + t + " " + Math.round(ans * E));
		}
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