package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드 {
	static final int INF = 10000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] D = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(D[i], INF);
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			D[a][b] = Math.min(D[a][b], c);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if(k == i) continue;
				for (int j = 1; j <= n; j++) {
					if(k == j || i == j) continue;
					if(D[i][k] != INF && D[k][j] != INF
					&& D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(D[i][j] < INF) {
					sb.append(D[i][j] + " ");
				} else {
					sb.append(0 + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
