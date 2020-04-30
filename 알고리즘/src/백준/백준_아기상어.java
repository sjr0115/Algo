package 백준;

import java.io.*;
import java.util.*;

public class 백준_아기상어 {
	static int N, sy, sx, shark, min_dist, min_y, min_x;
	static int[][] map, dist;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sy = i;
					sx = j;
					map[i][j] = 0;
				}
			}
		}
		shark = 2;
		int fish_eat = 0;
		int ans = 0;
		while(true) {
			visit();
			bfs(sy, sx);
			
			if(min_y != 20 && min_x != 20) {
				ans += dist[min_y][min_x];
				fish_eat++;
				if(fish_eat == shark) {
					shark++;
					fish_eat = 0;
				}
				
				map[min_y][min_x] = 0;
				sy = min_y;
				sx = min_x;
			}else {
				break;
			}
		}
		System.out.println(ans);
	}
	
	public static void visit() {
		min_y = 20;
		min_x = 20;
		min_dist = 401;
		for(int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}
	}
	
	public static void bfs(int y, int x) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(y, x));
		dist[y][x] = 0;
		while(!q.isEmpty()) {
			XY tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int ny = tmp.y + dy[d];
				int nx = tmp.x + dx[d];
				
				if(ny >= 0 && nx >= 0 && ny < N && nx < N) {
					if(map[ny][nx] <= shark && dist[ny][nx] == -1) {
						dist[ny][nx] = dist[tmp.y][tmp.x] + 1;
						
						if(map[ny][nx] != 0 && map[ny][nx] < shark) {
							if(min_dist > dist[ny][nx]) {
								min_dist = dist[ny][nx];
								min_y = ny;
								min_x = nx;
							}else if(min_dist == dist[ny][nx]) {
								if(min_y == ny && min_x > nx) {
									min_x = nx;
								}else if(min_y > ny) {
									min_y = ny;
									min_x = nx;
								}
							}
						}
						q.add(new XY(ny, nx));
					}
				}
			}
		}
	}
	
	public static class XY {
		int y;
		int x;
		public XY(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
