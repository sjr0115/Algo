package swexpert;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로_강사코딩 {
	static int N;
	static long[][] islands;
	static double E;
	static long[][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer xLine = new StringTokenizer(br.readLine());
			StringTokenizer yLine = new StringTokenizer(br.readLine());
			
			islands = new long[N][2];
			for(int n = 0; n < N; n++) {
				islands[n] = new long[] {Long.parseLong(xLine.nextToken()), Long.parseLong(yLine.nextToken())};
			}
			E = Double.parseDouble(br.readLine());
			graph = new long[N][N];
			long[] from, to;
			for (int r = 0; r < N; r++) {
				from = islands[r];
				for (int c = r + 1; c < N; c++) {
					to = islands[c];
					graph[c][r] = graph[r][c] = (from[0] - to[0]) * (from[0] - to[0]) + (from[1] - to[1]) * (from[1] - to[1]);
				}
			}
			double cost = prim(0) * E;
			System.out.println("#" + t + " " + Math.round(cost));
		}
	}
	private static long prim(int start) {
//		long cost = 0;
		//MST에 들어가지 않는 것들
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//모든 정점들을 다 관리
		Edge[] dynamicGraph = new Edge[N];
		
		for (int n = 0; n < dynamicGraph.length; n++) {
			dynamicGraph[n] = new Edge(n, Long.MAX_VALUE);
			if(n == start) {
				dynamicGraph[n].cost = 0;
			}
			pq.add(dynamicGraph[n]);
		}
		long cost = 0;
		
		while(!pq.isEmpty()) {
			Edge front = pq.poll();
			cost += front.cost;
			
			for (int i = 0; i < dynamicGraph.length; i++) {
				Edge child = dynamicGraph[i];
				if(pq.contains(child)) {
					long tempCost = graph[front.idx][child.idx];
					if(tempCost < child.cost) {
						child.cost = tempCost;
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		return cost;
	}
	
	static class Edge implements Comparable<Edge> {
		int idx;
		long cost;
		public Edge(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.cost, o.cost);
		}
	}
}
