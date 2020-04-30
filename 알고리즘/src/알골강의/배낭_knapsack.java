package 알골강의;

import java.util.Arrays;

public class 배낭_knapsack {

	public static void main(String[] args) {
		int W = 10; // 배낭의 무게(최종 구하고자하는 목표)
		int[] w = { 0, 5, 4, 6, 3 }; // 무게 (kg)
		int[] v = { 0, 10, 40, 30, 50 }; // 가치(만원)
		int[][] K = new int[w.length][W + 1]; // 최대 베낭에 담은 물건의 가치

		for (int i = 1; i < K.length; i++) {
			for (int j = 0; j < w[i]; j++) {
				K[i][j] = K[i - 1][j];
			}
			for (int j = w[i]; j <= W; j++) {
				int now = K[i - 1][j - w[i]] + v[i]; // 물건 선택을 고려한 경우
				int pre = K[i - 1][j]; // 물건 선택을 고려하지 않은 경우
				K[i][j] = now >= pre ? now : pre;
			}
		}
		for (int i = 0; i < K.length; i++) {
			System.out.println(Arrays.toString(K[i]));
		}
	}

}
