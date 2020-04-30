package 백준;

import java.io.*;

public class 피보나치함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] memo = new int[N + 1][2];
			
			if(N == 0) {
				sb.append("1 0\n");
				continue;
			}
			
			if(N == 1) {
				sb.append("0 1\n");
				continue;
			}
			
			memo[0][0] = 1;
			memo[1][1] = 1;
			for (int i = 2; i <= N; i++) {
				memo[i][0] = memo[i - 1][0] + memo[i - 2][0];
				memo[i][1] = memo[i - 1][1] + memo[i - 2][1];
			}
			sb.append(memo[N][0] + " " + memo[N][1] + "\n");
		}
		System.out.println(sb.toString());
	}

}
