package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d3_8658_Summation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] numbers = new int[10];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < 10; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
				int sum = 0;
				while(numbers[i] > 0) {
					sum += numbers[i] % 10;
					numbers[i] /= 10;
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			System.out.println("#" + t + " " + max + " " + min);
		}
	}

}
