package swexpert;

import java.util.Scanner;

public class 화섭이의미생물배양_강사코딩 {

	public static int E, S, T, A, B;
	public static String[] sn;
	public static int[] tm;
	static int min;

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		E = scann.nextInt();

		for (int iT = 1; iT <= E; iT++) {
			S = scann.nextInt();
			T = scann.nextInt();
			A = scann.nextInt();
			B = scann.nextInt();
			min = Integer.MAX_VALUE;
			if (B == 1) {
				if ((T - S) % A == 0) {
					min = (T - S) / A;
				} else {
					min = Integer.MAX_VALUE;
				}
			} else {
				dfs(T, 0);
			}
			System.out.printf("#%d %d\n", iT, min == Integer.MAX_VALUE ? -1 : min);
		}
		scann.close();
	}

	public static void dfs(int t3, int count) {
		if (t3 == S) {
			if (min > count) {
				min = count;
			}
			return;
		}
		if (t3 < S) {
			return;
		}
		if (t3 % B == 0) {
			if (t3 / B < S) {
				dfs(t3 - A, count + 1);
			} else {
				dfs(t3 / B, count + 1);
			}
		} else {
			dfs(t3 - A, count + 1);
		}
	}
}