package 백준;

import java.io.*;

public class nx2타일링 {
	static int[] memo;
	static final int INF = 10007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		memo = new int[n + 1];
		
		memo[1] = 1;
		if(n >= 2) {
			memo[2] = 2;
		}

		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % INF;
		}
		System.out.println(memo[n]);
	}

}
