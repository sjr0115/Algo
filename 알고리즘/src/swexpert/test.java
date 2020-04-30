package swexpert;

import java.io.*;
import java.util.*;

public class test {
	static int N, M, K, cnt;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static PriorityQueue<Cell> pq = new PriorityQueue<>();
	static boolean[][] visited = new boolean[701][701];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			pq.clear();
			cnt = 0;
			
			for (int i = 0; i < visited.length; i++) {
				Arrays.fill(visited[i], false);
			}
			
			for (int i = 350; i < 350 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 350; j < 350 + M; j++) {
					int size = Integer.parseInt(st.nextToken());
					
					if(size != 0) {
						visited[i][j] = true;
						pq.add(new Cell(i, j, size, size + 1));
					}
				}
			}
			
			bfs();
			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		int time = 0;
		while(time <= K) {
			Cell cur = pq.poll();
			time = cur.time;
			
			if(time > K) break;
			
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				
				if(visited[ny][nx]) continue;
				visited[ny][nx] = true;
				pq.add(new Cell(ny, nx, cur.size, time + cur.size + 1));
				
				if(time + 2 * cur.size > K) cnt++;
			}
		}
	}

	static class Cell implements Comparable<Cell> {
		int y, x, size, time;

		public Cell(int y, int x, int size, int time) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.time = time;
		}

		@Override
		public int compareTo(Cell o) {
			if(this.time == o.time) {
				return Integer.compare(o.size, this.size);
			}
			return Integer.compare(this.time, o.time);
		}
	}
}
