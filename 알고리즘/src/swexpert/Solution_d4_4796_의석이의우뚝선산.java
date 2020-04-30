package swexpert;

import java.io.IOException;
import java.util.Scanner;

public class Solution_d4_4796_의석이의우뚝선산 {
	static int N, ans;
	static int[] mountain;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			mountain = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				mountain[i] = sc.nextInt();
			}
			ans = 0;
			solve();
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}

	private static void solve() {
		for (int i = 1; i <= N - 2; i++) {
			int hcnt = 0;
			int lcnt = 0;
			if(mountain[i] < mountain[i + 1] && mountain[i + 1] > mountain[i + 2]) {
				for(int j = i + 1; j >= 2; j--) {
					if(mountain[j - 1] < mountain[j]) hcnt++;
					else break;
				}
				for(int j = i + 1; j <= N - 1; j++) {
					if(mountain[j] > mountain[j + 1]) lcnt++;
					else break;
				}
				ans += hcnt * lcnt;
			}
		}
	}

}
