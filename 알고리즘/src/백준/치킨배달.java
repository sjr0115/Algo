package 백준;

import java.io.*;
import java.util.*;

public class 치킨배달 {
	static int N, M, ans;
	static int[][] map;
	static boolean[] visited;
	static List<Point> houseList;
	static List<Point> chichenList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		houseList = new ArrayList<Point>();
		chichenList = new ArrayList<Point>();
		List<Point> selectList = new ArrayList<Point>();
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					houseList.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chichenList.add(new Point(i, j));
				}
			}
		}

		visited = new boolean[chichenList.size()];
		dfs(0, 0, selectList, visited);
		System.out.println(ans);
	}

	private static void dfs(int start, int depth, List<Point> selectList, boolean[] visited) {
		if(depth == M) {
			int sum = calc(selectList);
			ans = Math.min(ans, sum);
			return;
		}
		
		for (int i = start; i < chichenList.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selectList.add(chichenList.get(i));
			dfs(i + 1, depth + 1, selectList, visited);
			selectList.remove(selectList.size() - 1);
			visited[i] = false;
		}
	}

	private static int calc(List<Point> selectList) {
		int sum = 0;
		for (int i = 0; i < houseList.size(); i++) {
			int minDist = Integer.MAX_VALUE;
			for (int j = 0; j < selectList.size(); j++) {
				int len = Math.abs(houseList.get(i).y - selectList.get(j).y) + Math.abs(houseList.get(i).x - selectList.get(j).x);
				minDist = Math.min(minDist, len);
			}
			sum += minDist;
		}
		return sum;
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
