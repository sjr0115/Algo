package 백준;

import java.io.*;

public class 파도반수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] triangle = new long[101];
		
		triangle[1] = 1;
		triangle[2] = 1;
		triangle[3] = 1;
		triangle[4] = 2;
		triangle[5] = 2;
		
		for (int i = 6; i < triangle.length; i++) {
			triangle[i] = triangle[i - 1] + triangle[i - 5];
		}
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(triangle[N] + "\n");
		}
		System.out.println(sb.toString());
	}

}
