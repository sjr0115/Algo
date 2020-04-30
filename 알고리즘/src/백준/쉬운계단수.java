package 백준;

import java.io.*;

public class 쉬운계단수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long INF = 1000000000;
		long[][] dp = new long[N + 1][10];
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = dp[i - 1][j + 1] % INF;
				} else if(j == 9) {
					dp[i][j] = dp[i - 1][j - 1] % INF;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % INF;
				}
			}
		}
		
		long ans = 0;
		for (int i = 1; i <= 9; i++) {
			ans += dp[N][i];
		}
		
		System.out.println(ans % INF);
	}

}
