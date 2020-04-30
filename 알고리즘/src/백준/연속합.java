package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		if(n == 1) {
			System.out.println(numbers[1]);
		} else if(n == 2) {
			System.out.println(Math.max(numbers[2], numbers[1] + numbers[2]));
		} else {
			dp[1] = numbers[1];
			int ans = numbers[1];
			for (int i = 2; i <= n; i++) {
				dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
				ans = Math.max(ans, dp[i]);
			}
			
			System.out.println(ans);
		}
	}

}
