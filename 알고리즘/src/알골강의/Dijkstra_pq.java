package 알골강의;

import java.util.*;

public class Dijkstra_pq {
	static class Edges implements Comparable<Edges>{
		int v, weight;

		public Edges(int v, int weight) {
			super();
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edges o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edges [v=" + v + ", weight=" + weight + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<Edges>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			//첫 번째 출발지, 두번째 도착지, 세번째 가충치
			adj[sc.nextInt()].add(new Edges(sc.nextInt(), sc.nextInt()));
		}
		
		//dijkstra
		PriorityQueue<Edges> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edges[] D = new Edges[V];
		//0번에서 출발
		for (int i = 0; i < V; i++) {
			//원하는 출발지
			if(i == 0) {
				D[i] = new Edges(i, 0);
			} else {
				D[i] = new Edges(i, Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		while(!pq.isEmpty()) {
			Edges edges = pq.poll();
			
			for (Edges next : adj[edges.v]) {
				// check 되지 않았으면서 D[next.v] > D[edges.v] + next.weght
				if(!check[next.v] && D[next.v].weight > D[edges.v].weight + next.weight) {
					D[next.v].weight = D[edges.v].weight + next.weight;
					//decrease key
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edges.v] = true;
		}
		System.out.println(Arrays.toString(D));
	}
}
