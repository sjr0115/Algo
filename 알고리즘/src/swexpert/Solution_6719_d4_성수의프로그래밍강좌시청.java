package swexpert;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6719_d4_성수의프로그래밍강좌시청 {
	static int N, K;
	static double ans;
	static int[] M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			M = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(M);
			ans = 0;
			for (int i = N - K; i < N; i++) {
				ans = (ans + M[i]) / 2;
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
