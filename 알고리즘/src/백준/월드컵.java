package 백준;

import java.io.*;
import java.util.*;

public class 월드컵 {
	static int[] match1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] match2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	static int[] win;
	static int[] draw;
	static int[] lose;
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		win = new int[6];
		draw = new int[6];
		lose = new int[6];
		
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int gameWin = 0;
			int gameDraw = 0;
			int gameLose = 0;
			check = false;
			
			for (int i = 0; i < 6; i++) {
				gameWin += win[i] = Integer.parseInt(st.nextToken());
				gameDraw += draw[i] = Integer.parseInt(st.nextToken());
				gameLose += lose[i] = Integer.parseInt(st.nextToken());
			}
			
			if(gameWin + gameDraw + gameLose != 30) {
				check = false;
			} else {
				worldcup(0);
			}
			
			sb.append((check ? 1 : 0) + " ");
		}
		System.out.println(sb.toString());
	}

	private static void worldcup(int game) {
		if(check) return;
		if(game == 15) {
			check = true;
			return;
		}
		
		int m1 = match1[game];
		int m2 = match2[game];
		
		if(win[m1] > 0 && lose[m2] > 0) {
			win[m1]--;
			lose[m2]--;
			worldcup(game + 1);
			win[m1]++;
			lose[m2]++;
		}
		
		if(lose[m1] > 0 && win[m2] > 0) {
			lose[m1]--;
			win[m2]--;
			worldcup(game + 1);
			lose[m1]++;
			win[m2]++;
		}
		
		if(draw[m1] > 0 && draw[m2] > 0) {
			draw[m1]--;
			draw[m2]--;
			worldcup(game + 1);
			draw[m1]++;
			draw[m2]++;
		}
	}
	
}
