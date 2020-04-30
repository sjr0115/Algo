package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 역사 {
	static int n, k, s;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = -1;
			map[v][u] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(map[j][i] == 0) continue;
				for (int k = 1; k <= n; k++) {
					if(map[j][i] != map[i][k]) continue;
					map[j][k] = map[j][i];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		s = Integer.parseInt(br.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			sb.append(map[u][v] + "\n");
		}
		System.out.println(sb);
	}
}