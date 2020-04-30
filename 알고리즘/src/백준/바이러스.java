package 백준;

import java.io.*;
import java.util.*;

public class 바이러스 {
	static int N, M;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next = 1; next <= N; next++) {
				if(map[cur][next] == 1 && !visited[next]) {
					visited[next] = true;
					cnt++;
					q.add(next);
				}
			}
		}
		return cnt;
	}

}
