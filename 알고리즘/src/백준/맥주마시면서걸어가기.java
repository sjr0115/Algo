package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {
	static int n;
	static boolean[] visited;
	static ArrayList<Point> arr;
	static boolean check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n + 2];
			arr = new ArrayList<>();
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));		
			}
			check = false;
			dfs(0);
			if(check) {
				sb.append("happy");
			} else {
				sb.append("sad");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int idx) {
		if(idx == arr.size() - 1) {
			check = true;
			return;
		}
		visited[idx] = true;
		Point p = arr.get(idx);
		int y = p.y;
		int x = p.x;
		
		for (int i = 0; i < arr.size(); i++) {
			if(visited[i]) continue;
			int dist = Math.abs(y - arr.get(i).y) + Math.abs(x - arr.get(i).x);
			
			if(1000 >= dist) {
				dfs(i);
			}
			
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
