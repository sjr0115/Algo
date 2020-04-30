package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_11559_puyopuyo {
	static int H, W, cnt, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		H = 12;
		W = 6;
		map = new char[H][W];
		for(int i = 0; i < H; i++) {
			String data = bf.readLine();
			map[i] = data.toCharArray();
		}
		
		while(true) {
			visited = new boolean[H][W];
			cnt = 0;
			for(int i = H - 1; i >= 0; i--) {
				for(int j = W - 1; j >= 0; j--) {
					if(!visited[i][j] && map[i][j] != '.') {
						bfs(i, j);
					}
				}
			}
			
			if(cnt == 0) break;
			else ans++;
			
			search();
		}
		System.out.println(ans);
		
	}
	
	public static void bfs(int y, int x) {
		Queue<XY> q = new LinkedList<XY>();
		q.add(new XY(y, x));
		ArrayList<XY> save = new ArrayList<XY>();
		char same = map[y][x];
		int count = 0;
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			XY tmp = q.poll();
			save.add(tmp);
			count++;
			
			for(int d = 0; d < 4; d++) {
				int ny = tmp.y + dy[d];
				int nx = tmp.x + dx[d];
				if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
				if(!visited[ny][nx] && map[ny][nx] == same) {
					visited[ny][nx] = true;
					q.add(new XY(ny, nx));
				}
			}
			
			if(count >= 4) {
				cnt++;
				for(int i = 0; i < save.size(); i++) {
					XY savetmp = save.get(i);
					map[savetmp.y][savetmp.x] = '.';
				}
			}
		}
	}
	
	public static void search() {
		for(int i = H - 1; i >= 0; i--) {
			for(int j = W - 1; j >= 0; j--) {
				if(map[i][j] == '.') {
					swap(i, j);
				}
			}
		}
	}
	
	public static void swap(int a, int b) {
		int t = -1;
		for(int i = H - 1; i > a; i--) {
				if(map[i][b] == '.') {
					t = i;
					break;
			}
		}
		
		if(t != -1) {
			char temp = map[t][b];
			map[t][b] = map[a][b];
			map[a][b] = temp;
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
