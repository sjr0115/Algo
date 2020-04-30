package 백준;

import java.io.*;

public class 일이삼더하기 {
	static int[] memo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		memo = new int[11];
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 4; i <= n; i++) {
				memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
			}
			sb.append(memo[n] + "\n");
		}
		System.out.println(sb.toString());
	}
}
