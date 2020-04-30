package 백준;

import java.io.*;
import java.util.*;

public class 주사위윷놀이 {
	static int ans;
	static int[] game;
	static int[] horse;
	static int[][] map = { { 0, 1, 2, 3, 4, 5 }, { 2, 2, 3, 4, 5, 6 }, { 4, 3, 4, 5, 6, 7 }, { 6, 4, 5, 6, 7, 8 },
			{ 8, 5, 6, 7, 8, 9 }, { 10, 21, 22, 23, 24, 25 }, { 12, 7, 8, 9, 10, 11 }, { 14, 8, 9, 10, 11, 12 },
			{ 16, 9, 10, 11, 12, 13 }, { 18, 10, 11, 12, 13, 14 }, { 20, 27, 28, 24, 25, 26 },
			{ 22, 12, 13, 14, 15, 16 }, { 24, 13, 14, 15, 16, 17 }, { 26, 14, 15, 16, 17, 18 },
			{ 28, 15, 16, 17, 18, 19 }, { 30, 29, 30, 31, 24, 25 }, { 32, 17, 18, 19, 20, 0 }, { 34, 18, 19, 20, 0, 0 },
			{ 36, 19, 20, 0, 0, 0 }, { 38, 20, 0, 0, 0, 0 }, { 40, 0, 0, 0, 0, 0 }, { 13, 22, 23, 24, 25, 26 },
			{ 16, 23, 24, 25, 26, 20 }, { 19, 24, 25, 26, 20, 0 }, { 25, 25, 26, 20, 0, 0 }, { 30, 26, 20, 0, 0, 0 },
			{ 35, 20, 0, 0, 0, 0 }, { 22, 28, 24, 25, 26, 20 }, { 24, 24, 25, 26, 20, 0 }, { 28, 30, 31, 24, 25, 26 },
			{ 27, 31, 24, 25, 26, 20 }, { 26, 24, 25, 26, 20, 0 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		game = new int[10];
		horse = new int[4];
		for (int i = 0; i < 10; i++) {
			game[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		dfs(0, 0);
		System.out.println(ans);
		
	}
	private static void dfs(int idx, int score) {
		if(idx == 10) {
			ans = Math.max(ans, score);
			return;
		}
		
		loop: for (int i = 0; i < 4; i++) {
			if(horse[i] == - 1) continue;
			int now = horse[i];
			int next = map[now][game[idx]];
			if(next == 0) {
				horse[i] = -1;
				dfs(idx + 1, score);
				horse[i] = now;
			}
			for (int j = 0; j < 4; j++) {
				if(i == j) continue;
				if(horse[j] == next)
					continue loop;
			}
			horse[i] = next;
			dfs(idx + 1, score + map[next][0]);
			horse[i] = now;
		}
	}

}
