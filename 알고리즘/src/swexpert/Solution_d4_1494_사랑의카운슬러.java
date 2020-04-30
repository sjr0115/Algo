package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1494_사랑의카운슬러 {
	static int[] y, x, ay, ax, by, bx;
	static int N;
	static boolean[] check;
	static long ans, min;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(bf.readLine());
			y = new int[N];
			x = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				y[i] = Integer.parseInt(st.nextToken());
				x[i] = Integer.parseInt(st.nextToken());
			}
			check = new boolean[N];
			ay = new int[N / 2];
			ax = new int[N / 2];
			by = new int[N / 2];
			bx = new int[N / 2];
			ans = 0;
			min = Long.MAX_VALUE;
			solve(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	public static void solve(int start, int count) {
		if(count == N / 2) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if (!check[i]) {
					by[cnt] = y[i];
					bx[cnt++] = x[i];
				}
			}
			int sumY = 0;
			int sumX = 0;
			for(int i = 0; i < N / 2; i++) {
				sumY += (ay[i] - by[i]);
				sumX += (ax[i] - bx[i]);
			}
			ans = (long)Math.pow(sumX, 2) + (long)Math.pow(sumY, 2);
			min = Math.min(ans, min);
			return;
			
		}
		for(int i = start; i < N; i++) {
			if(!check[i]) {
				ay[count] = y[i];
				ax[count] = x[i];
				check[i] = true;
				solve(start + 1, count + 1);
				check[i] = false;
			}
		}
	}
}
