package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 운동 {
	static final int INF = 10000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] map = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				if(k == i) continue;
				for (int j = 1; j <= V; j++) {
					if(map[i][k] != INF && map[k][j] != INF
					 && map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int ans = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if(i == j) continue;
				if(map[i][j] != INF && map[j][i] != INF) {
					ans = Math.min(ans, map[i][j] + map[j][i]);
				}
			}
		}
		
		System.out.println(ans == INF ? -1 : ans);
	}

}
