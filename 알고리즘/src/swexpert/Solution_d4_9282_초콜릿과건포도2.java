package swexpert;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_9282_초콜릿과건포도2 {
	static int n, m, result;
	static int[][] map;
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			dp = new int[n + 1][m + 1][n + 1][m + 1];
			for(int[][][] d1 : dp) {
				for(int[][] d2 : d1) {
					for(int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			사이즈가 정해져있으면 처리
			result = dfs(0, 0, n, m);
			System.out.println("#" + t + " " + result);
		}
	}
	static int dfs(int y, int x, int h, int w) {
		if(h == 1 && w == 1) {
			return 0;
		}
		if(dp[y][x][h][w] != Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}
//		기존에 있던 덩어리의 건포도 개수
		int sum = 0;
		
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
//		가로로 나누어서 비용을 최소비용으로 구한다.
		for(int i = 1; i < h; i++) {
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum + dfs(y, x, i, w) + dfs(y + i, x, h - i, w));
		}
//		세로로 나누어서 비용을 최소비용으로 구한다.
		for(int i = 1; i < w; i++) {
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum + dfs(y, x, h, i) + dfs(y, x + i, h, w - i));
		}
		
		return dp[y][x][h][w];
	}
}
