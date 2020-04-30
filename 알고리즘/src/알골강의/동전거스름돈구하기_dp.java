package 알골강의;

import java.io.*;
import java.util.Arrays;

public class 동전거스름돈구하기_dp {
// 1원 4원 6원
	static int[] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N + 1];
		
		for (int i = 0; i < memo.length; i++) {
			memo[i] = i; //1원자리 필요한 개수
		}
		System.out.println(Arrays.toString(memo));
		
//		1원, 4원 동전을 모두 고려
		for (int i = 4; i < memo.length; i++) {
//			memo[i]: 1원짜리 동전만 고려한 최소개수
//			memo[i - 4]: 4원짜리 동전만 고려한 최소개수
			if(memo[i] > memo[i - 4] + 1) {
				memo[i] = memo[i - 4] + 1;
			}
		}
		System.out.println(Arrays.toString(memo));
//		1, 4, 6
		for (int i = 6; i < memo.length; i++) {
//			memo[i]: 1, 4원짜리 동전만 고려한 최소개수
//			memo[i - 6]: 6원짜리 동전만 고려한 최소개수
			if(memo[i] > memo[i - 6] + 1) {
				memo[i] = memo[i - 6] + 1;
			}
		}
		System.out.println(Arrays.toString(memo));
		
		System.out.println(memo[N]);
	}
	
}
