package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 이항계수3 {
	static long N, K;
	static final int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		long a = f(N);
		long b = f(N - K) * f(K) % MOD;
		long ans = (long) (a * Math.pow(b, MOD - 2) % MOD);
		System.out.println(ans);
	}
	private static long f(long n) {
		long fac = 1;
		while(n > 1) {
			fac = (fac * n) % MOD;
			n--;
		}
		return fac;
	}

}
