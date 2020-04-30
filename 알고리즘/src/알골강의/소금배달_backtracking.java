package 알골강의;

import java.io.*;

public class 소금배달_backtracking {
	static int min = Integer.MAX_VALUE; // 최소봉지 개수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		gogosing(M, 0);
//		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static void gogosing(int M, int cnt) {
		if(M < 0) {
			return;
		} else if( M == 0) {
//			if(min > cnt) {
//				min = cnt;
//			}
			System.out.println(cnt == Integer.MAX_VALUE ? -1 : cnt);
			System.exit(0);
		} else {
			gogosing(M - 5, cnt + 1);
			gogosing(M - 3, cnt + 1);
		}
	}

}
