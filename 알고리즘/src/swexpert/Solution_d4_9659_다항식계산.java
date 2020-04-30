package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d4_9659_다항식계산 {
	static int N, x;
	static int[] t, a, b;
	static long[] ans;
	static final long MOD = 998244353;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			t = new int[N + 1];
			a = new int[N + 1];
			b = new int[N + 1];
			ans = new long[N + 1];
			for (int i = 2; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			ans[0] = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < M; i++) {
				x = Integer.parseInt(st.nextToken());
				ans[1] = x;
				for (int j = 2; j <= N; j++) {
					if(t[j] == 1) {
						ans[j] = (ans[a[j]] + ans[b[j]]) % MOD;
					} else if(t[j] == 2) {
						ans[j] = (a[j] * ans[b[j]]) % MOD;
					} else if(t[j] == 3) {
						ans[j] = (ans[a[j]] * ans[b[j]]) % MOD;
					}
				}
				sb.append(ans[N]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
