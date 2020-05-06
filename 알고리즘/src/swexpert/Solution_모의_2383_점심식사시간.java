package swexpert;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_모의_2383_점심식사시간 {
	static int N, P, S, ans;
	static int[][] map;
	static Point[] people, stairs;
	static int[] len, caseCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			people = new Point[10];
			stairs = new Point[2];
			len = new int[2];
			P = 0;
			S = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						people[P++] = new Point(i, j); 
					} else if(map[i][j] > 1) {
						stairs[S++] = new Point(i, j);
						len[S - 1] = map[i][j];
					}
				}
			}
			
			ans = Integer.MAX_VALUE;
			caseCnt = new int[P];
			dfs(0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void dfs(int depth) {
		if(depth == P) {
			goStair();
			return;
		}
		for (int i = 0; i < 2; i++) {
			caseCnt[depth] = i;
			dfs(depth + 1);
		}
	}

	private static void goStair() {
		PriorityQueue<Integer> pq0 = new PriorityQueue<>();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		
		for (int i = 0; i < P; i++) {
			if(caseCnt[i] == 0) {
				pq0.add(Math.abs(people[i].y - stairs[0].y) + Math.abs(people[i].x - stairs[0].x));
			} else {
				pq1.add(Math.abs(people[i].y - stairs[1].y) + Math.abs(people[i].x - stairs[1].x));
			}
		}
		
		int people = P;
		int[] stair0 = new int[3];
		int[] stair1 = new int[3];
		int time = 0;
		
		while(true) {
			if(people == 0) {
				boolean success = true;
				for (int i = 0; i < 3; i++) {
					if(stair0[i] != 0 || stair1[i] != 0) {
						success = false;
						break;
					}
				}
				if(success) break;
			}
			
			for (int i = 0; i < 3; i++) {
				if(stair0[i] == 0) {
					if(!pq0.isEmpty()) {
						if(pq0.peek() <= time) {
							pq0.poll();
							stair0[i] = len[0];
							people--;
						}
					}
				} else {
					stair0[i]--;
					if(stair0[i] == 0) {
						if(!pq0.isEmpty()) {
							if(pq0.peek() <= time) {
								pq0.poll();
								stair0[i] = len[0];
								people--;
							}
						}
					}
				}
				
				if(stair1[i] == 0) {
					if(!pq1.isEmpty()) {
						if(pq1.peek() <= time) {
							pq1.poll();
							stair1[i] = len[1];
							people--;
						}
					}
				} else {
					stair1[i]--;
					if(stair1[i] == 0) {
						if(!pq1.isEmpty()) {
							if(pq1.peek() <= time) {
								pq1.poll();
								stair1[i] = len[1];
								people--;
							}
						}
					}
				}
			}
			
			time++;
		}
		ans = Math.min(ans, time);
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
