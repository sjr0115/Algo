package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 저울 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] D = new int[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			D[a][b] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(k == i) continue;
				for (int j = 1; j <= N; j++) {
					if(D[i][k] == 1 && D[k][j] == 1) {
						D[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if(i == j) continue;
				if(D[i][j] != 1 && D[j][i] != 1) {
					cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}

}
