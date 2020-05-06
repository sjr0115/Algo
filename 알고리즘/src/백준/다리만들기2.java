package 백준;

import java.io.*;
import java.util.*;

public class 다리만들기2 {
	static int[][] map;
	static int N, M, land;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static Queue<Point> q;
	static ArrayList<Point> bridge;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		land = 0;
		q = new LinkedList<>();
		bridge = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) - 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0 && !visited[i][j]) {
					land++;
					landBfs(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					q.add(new Point(i, j, 0));
					bridgeBfs(map[i][j]);
				}
			}
		}
		
		parent = new int[land + 1];
		for (int i = 1; i <= land; i++) {
			parent[i] = i;
		}
		
		Collections.sort(bridge);
		kruskal();
	}

	private static void kruskal() {
		int cnt = 0;
		int dist = 0;
		
		for (Point p : bridge) {
			if(find(p.y) == find(p.x)) continue;
			union(p.y, p.x);
			dist += p.dist;
			cnt++;
		}
		
		if(cnt != land - 1) System.out.println(-1);
		else System.out.println(dist);
	}

	private static void union(int y, int x) {
		int py = find(y);
		int px = find(x);
		
		parent[px] = py;
	}

	private static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static void bridgeBfs(int land) {
		while(!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				int dist = 0;
				boolean connect = false;
				while(true) {
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == land) break;
					
					if(map[ny][nx] != -1) {
						connect = true;
						break;
					}
					
					ny += dy[d];
					nx += dx[d];
					dist++;
				}
				
				if(connect) {
					if(dist < 2) continue;
					bridge.add(new Point(land, map[ny][nx], dist));
				}
			}
		}
	}

	private static void landBfs(int y, int x) {
		q.add(new Point(y, x, 0));
		map[y][x] = land;
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] != 0) continue;
				visited[ny][nx] = true;
				map[ny][nx] = land;
				q.add(new Point(ny, nx, 0));
			}
		}
	}
	
	static class Point implements Comparable<Point>{
		int y, x, dist;

		public Point(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return this.dist - o.dist;
		}
	}
}
