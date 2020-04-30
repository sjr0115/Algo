package 백준;

import java.io.*;

public class 일로만들기 {
	static int[] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];
		
		System.out.println(dp(N));
	}
	private static int dp(int N) {
		if(N == 1) {
			return 0;
		}
		if(memo[N] > 0) {
			return memo[N];
		}
		
		memo[N] = dp(N - 1) + 1;
		if(N % 2 == 0) {
			memo[N] = Math.min(memo[N], dp(N / 2) + 1);
		}
		if(N % 3 == 0) {
			memo[N] = Math.min(memo[N], dp(N / 3) + 1);
		}
		
		return memo[N];
	}

}
