package 알골강의;

import java.util.Arrays;
import java.util.Scanner;

//pq X 간선이 매우 많을 때 유리
/*
7 11
0 1 9
0 2 5
0 5 19
2 3 1
2 5 15
3 0 2
3 1 7
3 5 17
3 4 8
4 6 4
6 1 3
 */
public class Dijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		int[] D = new int[V];
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] check = new boolean[V];
		//dijkstra 시작점이 a 정점이라면 D[a] = 0
		D[0] = 0;
		for (int i = 0; i < V - 1; i++) {
			int min = Integer.MAX_VALUE; // 가장 작은 값을 기억할 변수
			int index = -1; // 그 위치를 기억할 변수
			for (int j = 0; j < V; j++) {
				//아직 처리하지 않았으면서, 가장 짧은 거리라면
				if(!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			
			if(index == -1) break;
			
			//새로운 친구로 부터 갈 수 있는 경로들을 업데이트
			for (int j = 0; j < V; j++) {
				//아직 처리하지 않았으면서, 경로가 존재하고, D[index] + adj[index] < D[j]
				if(!check[j] && adj[index][j] != 0 && D[index] + adj[index][j] < D[j]) {
					D[j] = D[index] + adj[index][j];
				}
			}
			//처리된놈으로 체크
			check[index] = true;
		}
		System.out.println(Arrays.toString(D));
	}

}
