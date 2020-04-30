package 알골강의;

import java.io.*;

public class 막대문제_dp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N + 1];
		memo[1] = 2;
		memo[2] = 5;
		for (int i = 3; i <= N; i++) {
			memo[i] = 2 * memo[i - 1] + memo[i - 2];
		}
		System.out.println(memo[N]);
	}

}
