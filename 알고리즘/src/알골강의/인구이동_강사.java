package 알골강의;

import java.io.*;
import java.util.*;

public class 인구이동_강사 {
	static int N, L, R;
	private static boolean[][] visited;
	static int[][] m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N * N 땅의 크기
		L = Integer.parseInt(st.nextToken()); // L ~ R
		R = Integer.parseInt(st.nextToken()); // 
		m = new int[N][N];
		
		for (int i = 0; i < m.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m.length; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0; // 인구이동의 횟수
		while(true) { // 인구 이동
			boolean change = false; // 인구이동 여부 체크
			//모든 칸 순회
			//BFS 탐색 인접한 국가와 L ~ R 범위 내의 인구차
			visited = new boolean[N][N];
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					if(!visited[i][j] && search(i, j))
						change = true;
				}
			}
			
			if(!change) {
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
	
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	private static boolean search(int r, int c) {
		ArrayList<Loc> al = new ArrayList<Loc>();
		Queue<Loc> q = new LinkedList<Loc>();
		Loc l = new Loc(r, c);
		al.add(l);
		q.offer(l);
		visited[r][c] = true;
		while(!q.isEmpty()) {
			l = q.poll();
			r = l.r;
			c = l.c;
			for (int i = 0; i < dc.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && diff(m[nr][nc], m[r][c])) {
					Loc nl = new Loc(nr, nc);
					al.add(nl);
					q.add(nl);
					visited[nr][nc] = true;
				}
			}
		}
		if(al.size() >= 2) {
			int total = 0;
			for (Loc loc : al) {
				total += m[loc.r][loc.c];
			}
			int avg = total / al.size();
			
			for (Loc loc : al) {
				m[loc.r][loc.c] = avg;
			}
			return true;
		}
		return false; // 인구가 없으면
	}
	
	private static boolean diff(int i, int j) {
		int sub = i >= j ? i - j : j - i;
		return L <= sub && sub <= R;
	}

	public static class Loc{
		int r, c;

		public Loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
