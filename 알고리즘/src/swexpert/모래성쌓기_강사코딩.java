package swexpert;

import java.io.*;
import java.util.*;

import jdk.nashorn.internal.runtime.regexp.joni.ast.Node;

public class 모래성쌓기_강사코딩 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for(int r = 0; r < H; r++) {
				String s = br.readLine();
				for(int c = 0; c < W; c++) {
					if(s.charAt(c) != '.') {
						map[r][c] = s.charAt(c) - '0';
					}
				}
			}
			Queue<Node> q = new LinkedList<>();
			for(int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					//바다라면
					if(map[r][c] == 0) {
						//8방에 대해서 모래가 존재한다면 견고함을 1 감소
						for(int d = 0; d < 8; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
							if(map[nr][nc] != 0) {
								map[nr][nc]--;
								if(map[nr][nc] == 0) {
									//원래는 모래였으나 깍여서 바다가 된 친구는 -1로 표시
									map[nr][nc] = -1;
									//다음 회차에서 주변 모래의 견고함을 줄이기 위해 큐에 저장
									q.add(new Node(nr, nc));
								}
							}
							
						}
					}
				}
			}
			int ans = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i = 0; i < size; i++) {
					//직전 루프에서 바다로 된 친구들
					Node node = q.poll();
					for(int d = 0; d < 8; d++) {
						int nr = node.r + dr[d];
						int nc = node.c + dc[d];
						if( nr < 0 || nc < 0 || nr >= H || nc >= W)
							continue;
						//모래가 발견되면
						if( map[nr][nc] > 0 ) {
							map[nr][nc]--;
							if( map[nr][nc] == 0 ) {
								//원래는 모래였으나 깍여서 바다가 된 친구는 -1로 표시하자.
								map[nr][nc] = -1;
								//다음 회차에서 주변 모래의 견고함을 줄이기 위해 큐에 저장.
								q.add(new Node(nr,nc));
							}
						}
					}
				}
				ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
