package swexpert;

import java.io.*;

public class Solution_d3_5601_쥬스나누기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.print("#" + t + " ");
			for(int i = 1; i <= N; i++) {
				System.out.print(1 + "/" + N + " ");
			}
			System.out.println();
		}
	}

}
