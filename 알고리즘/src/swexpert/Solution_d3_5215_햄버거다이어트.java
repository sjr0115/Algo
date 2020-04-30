package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d3_5215_햄버거다이어트 {
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
			score = new int[N];
			cal = new int[N];
			ans = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			backtrack(0, 0, 0);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void backtrack(int cnt, int s, int c) {
		if(c > L) {
			return;
		}
		if(cnt == N) {
			ans = Math.max(ans, s);
			return;
		}
		
		backtrack(cnt + 1, score[cnt] + s, cal[cnt] + c);
		backtrack(cnt + 1, s, c);
	}

}
