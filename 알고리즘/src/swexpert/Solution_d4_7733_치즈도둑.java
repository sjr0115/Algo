package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_7733_치즈도둑 {
	
	static int N, M;
	static int[][] map, visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		visited = new int[N][M];
		int hour = 0;
		boolean check = true;
		while(check) {
			visit(); //반복 실행하기 위해 방문 초기화
			bfs(0, 0);
			check = false; //마지막에 빠져나가기 위해 false함.
			
			loop : for(int i = 0; i < N; i++) { // 치즈 여부 한번만 실행
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 0) { //치즈 확인
						check = true;
						break loop;
					}
				}
			}
			hour++;
		}
		System.out.println(hour);
	}
	public static void bfs(int y, int x) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(y, x));
		
		while(!q.isEmpty()) {
			XY tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int ny = tmp.y + dy[d];
				int nx = tmp.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
				if(map[ny][nx] == 0 && visited[ny][nx] == 0) { // 공백 사방에 방문 여부 확
					visited[ny][nx] = 1; //방문한 것은 1
					q.add(new XY(ny, nx));
				}
				if(map[ny][nx] == 1) {
					visited[ny][nx]++; // 공백 사방에 치즈가 있으면 공기 유입 +1
					if(visited[ny][nx] >= 2) { // 공기 유입 2 이상이면 map은 0
						map[ny][nx] = 0;
					}
				}
			}
		}
		
	}
	
	public static void visit() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = 0;
			}
		}
	}
	
	public static class XY{
		int y;
		int x;
		
		public XY(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}