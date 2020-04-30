package swexpert;

import java.util.Scanner;

public class 달리기_강사코딩_터짐 {

	static int T, N, M;
	static int count;
	static int[] needs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int f, s;
			N = sc.nextInt();
			M = sc.nextInt();
			needs = new int[N];
			for (int i = 0; i < M; i++) {
				f = sc.nextInt() - 1;
				s = sc.nextInt() - 1;
				needs[f] |= (1 << s);
			}
			count = 0;
			dfs(0);
			System.out.println("#" + t + " " + count);
		}
	}
	private static void dfs(int flag) {
		if(flag == (1 << N) - 1) {
			count++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((flag & 1 << i) == 0) {
				if((flag & needs[i]) == needs[i]) {
					dfs(flag | 1 << i);
				}
			}
		}
	}

}
