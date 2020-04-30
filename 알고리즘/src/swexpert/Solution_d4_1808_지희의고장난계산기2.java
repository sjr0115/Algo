package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d4_1808_지희의고장난계산기2 {
	static int X, min;
	static boolean[] btn;
	static int[] memo;
	static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
//		min값을 초기화
			min = Integer.MAX_VALUE;
			btn = new boolean[10];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int num;
			for (int i = 0; i < 10; i++) {
				num = Integer.parseInt(st.nextToken());
				if(num == 1) {
//		btn 1이면 true로 설정
					btn[i] = true;
				}
			}
			X = Integer.parseInt(br.readLine().trim());
			size = (int) Math.sqrt(X);
			memo = new int[size];
			find(X, 0);
			min = min == Integer.MAX_VALUE ? -1 : min;
			System.out.println("#" + t + " " + min);
		}
		
	}

	private static int find(int x, int cnt) {
		if(x < size && memo[x] != 0) {
			return memo[x];
		}
		if(isMake(x + "")) {
			int count = len(x) + 1;
			if(cnt == 0) {
				min = count; // 계산 버튼을 위해 1을 더한다
			}
			if(x < size) {
				memo[x] = count;
			}
			return count;
		}
		
		int result = -1;
		for (int i = 2, end = (int) Math.sqrt(x) + 1; i < end; i++) {
			if(x % i == 0 && isMake(i + "")) {
				int len1 = len(i) + 1; //곱하기 버튼을 위해 1을 더한다.
				int len2 = find(x / i, cnt + 1);
				
				if(len2 > -1) {
					result = len1 + len2;
					if(result < min && x == X) {
						min = result;
					}
				}
			}
		}
		if(x < size) {
			memo[x] = result;
		}
		return result;
	}

	private static int len(int x) {
		return (int) Math.log10(x) + 1;
	}

	private static boolean isMake(String x) {
		for(char c : x.toCharArray()) {
			if(!btn[c - '0']) {
				return false;
			}
		}
		return true;
	}

}