package 백준;

import java.io.*;

public class 제곱수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}
