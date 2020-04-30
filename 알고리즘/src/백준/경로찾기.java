package 백준;

import java.io.*;
import java.util.*;

public class 경로찾기 {
	static int N;
	static int[][] map, result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		result = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			bfs(i, i);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(y, x));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < N; i++) {
				if(result[p.y][i] == 0 && map[p.x][i] == 1) {
					result[p.y][i] = 1;
					q.add(new Point(p.y, i));
				}
			}
		}
	}
	
	private static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
