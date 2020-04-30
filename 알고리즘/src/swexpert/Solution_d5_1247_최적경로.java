package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d5_1247_최적경로 {
	static int N, min;
	static Point[] area;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			area = new Point[N + 2];
			visited = new boolean[N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N + 2; i++) {
				area[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	public static void dfs(int idx, int cnt, int sum) {
		if(sum >= min) return;
		if(cnt == N) {
			sum += (Math.abs(area[idx].y - area[1].y) + Math.abs(area[idx].x - area[1].x));
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = 2; i < N + 2; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cnt + 1, sum + Math.abs(area[idx].y - area[i].y) + Math.abs(area[idx].x - area[i].x));
				visited[i] = false;
			}
		}
		
	}
	
	public static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
