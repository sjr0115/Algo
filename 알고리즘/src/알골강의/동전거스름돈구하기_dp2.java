package 알골강의;

import java.io.*;

public class 동전거스름돈구하기_dp2 {
// 1원 4원 6원
	static int[] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];
		System.out.println(dp(N));
	}
	
	private static int dp(int n) {
		if(n == 0) {
			return 0;
		}
		
		if(memo[n] > 0) {
			return memo[n];
		}
		
		memo[n] = dp(n - 1) + 1;
		
		if(n - 4 >= 0) {
			memo[n] = Math.min(memo[n], dp(n - 4) + 1);
		}
		
		if(n - 6 >= 0) {
			memo[n] = Math.min(memo[n], dp(n - 6) + 1);
		}
		
		return memo[n];
	}

}
