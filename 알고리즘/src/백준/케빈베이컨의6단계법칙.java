package 백준;

import java.io.*;
import java.util.*;

public class 케빈베이컨의6단계법칙 {
	static int N, M, min, minCnt;
	static int[][] friend, dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friend = new int[N + 1][N + 1];
		dist = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist[i], -1);
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a][b] = friend[b][a] = 1;
		}
		minCnt = Integer.MAX_VALUE;
		for (int i = N; i >= 1; i--) {
			bfs(i);
		}
		System.out.println(min);
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		dist[start][start] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(dist[start][i] == -1 && friend[cur][i] != 0) {
					dist[start][i] = dist[start][cur] + 1;
					q.add(i);
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += dist[start][i];
		}
		if(minCnt >= sum) {
			minCnt = sum;
			min = start;
		}
		
	}
	

}
