package swexpert;

import java.io.*;
import java.util.*;

public class Solution_1952_수영장 {
	static int[] cost, use;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost = new int[4];
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			use = new int[13];
			for (int i = 1; i <= 12; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			dfs(1, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	public static void dfs(int month, int total) {
		if(month >= 13) {
			min = Math.min(min, total);
			return;
		}
		dfs(month + 1, total + use[month] * cost[0]);
		dfs(month + 1, total + cost[1]);
		dfs(month + 3, total + cost[2]);
		dfs(month + 12, total + cost[3]);
	}
}
