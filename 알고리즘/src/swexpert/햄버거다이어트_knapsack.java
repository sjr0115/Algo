package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class 햄버거다이어트_knapsack {
	static int[][] K;
	static int[] score, cal;
	static int N, L, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N + 1];
			cal = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			K = new int[N + 1][L + 1];
			for (int i = 1; i < K.length; i++) {
				for (int j = 0; j < cal[i]; j++) {
					K[i][j] = K[i - 1][j];
				}
				for (int j = cal[i]; j <= L; j++) {
					int now = K[i - 1][j - cal[i]] + score[i];
					int pre = K[i - 1][j];
					K[i][j] = now >= pre ? now : pre;
				}
			}
			sb.append("#" + t + " " + K[N][L] + "\n");
		}
		System.out.println(sb.toString());
	}

}
