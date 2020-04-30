package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 스티커 {
	static int N;
	static int[][] dp, map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N  = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][N + 1];
			int[][] map = new int[2][N + 1];
			
			for (int i = 0; i <= 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				} 
			}
			
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}
