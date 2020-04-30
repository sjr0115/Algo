package 백준;

import java.io.*;

public class nx2타일링2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			if(i == 1) {
				dp[1] = 1;
			} else if(i == 2) {
				dp[2] = 3;
			} else {
				dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
			}
		}
		
		System.out.println(dp[n]);
	}

}
