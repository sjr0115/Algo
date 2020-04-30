package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][n];
		dp[0][0] = Integer.parseInt(br.readLine());
		int ans = Integer.MIN_VALUE;
		
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				
				if(j == 0) {
					dp[i][j] += dp[i - 1][j];
				} else if(j == i) {
					dp[i][j] += dp[i - 1][j - 1];
				} else {
					dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}
		
		System.out.println(ans);
	}

}
