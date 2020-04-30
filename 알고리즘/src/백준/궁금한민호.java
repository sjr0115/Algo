package 백준;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 궁금한민호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		int[][] D = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int dist = Integer.parseInt(st.nextToken());
				map[i][j] = dist;
				D[i][j] = dist;
			}
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 0; i <= N; i++) {
				if(k == i) continue;
				for (int j = 0; j <= N; j++) {
					if(j == k) continue;
					if(D[i][j] > D[i][k] + D[k][j]) {
						System.out.println(-1);
						return;
					}
					if(D[i][j] == D[i][k] + D[k][j]) {
						map[i][j] = 0;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				if(map[i][j] != 0) {
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);
	}

}
