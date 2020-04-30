package 백준;

import java.io.*;
import java.util.*;

public class 촌수계산 {
	static int x, y;
	static boolean[] visited;
	static int[][] family;
	static int[] dist;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		family = new int[N + 1][2];
		dist = new int[N + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			family[i][0] = Integer.parseInt(st.nextToken());
			family[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(bfs(x, m));
	}
	private static int bfs(int x, int m) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int search = q.poll();
			visited[search] = true;
			
			for (int i = 1; i <= m; i++) {
				if(family[i][0] == search && !visited[family[i][1]]) {
					q.add(family[i][1]);
					dist[family[i][1]] += dist[family[i][0]] + 1;
				} else if(family[i][1] == search && !visited[family[i][0]]) {
					q.add(family[i][0]);
					dist[family[i][0]] += dist[family[i][1]] + 1;
				}
			}
			if(!q.isEmpty() && q.peek() == y) {
				return dist[y];
			}
		}
		return -1;
	}

}
