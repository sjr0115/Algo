package 백준;

import java.io.*;

public class 계단오르기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] memo = new int[n + 1];
		int[] stairs = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		memo[1] = stairs[1];
		if(n >= 2) {
			memo[2] = stairs[1] + stairs[2];
		}
		
		for (int i = 3; i <= n; i++) {
			memo[i] = Math.max(memo[i - 3] + stairs[i - 1] + stairs[i], memo[i - 2] + stairs[i]);
		}
		
		System.out.println(memo[n]);
	}

}
