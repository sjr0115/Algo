package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_pro_5607_조합 {
	static int N, R;
	static final int MOD = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			long[] f = new long[N + 1];
			f[0] = 1;
			for (int i = 1; i <= N; i++) {
				f[i] = (f[i - 1] * i) % MOD; 
			}
			
			long parent = (f[R] * f[N - R]) % MOD;
			long pow = ferma(parent, MOD - 2);
			System.out.println("#" + t + " " + (f[N] * pow) % MOD);
		}
	}
	private static long ferma(long parent, int i) {
		if(i == 0) return 1;
		long cal = ferma(parent, i / 2);
		long pow = (cal * cal) % MOD;
		if(i % 2 == 0) return pow;
		else return (pow * parent) % MOD;
	}

}
