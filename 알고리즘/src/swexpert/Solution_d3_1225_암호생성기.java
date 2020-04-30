package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d3_1225_암호생성기 {
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		Queue<Integer> q = new LinkedList<Integer>();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				int number = Integer.parseInt(st.nextToken());
				q.add(number);
			}
			int num = -1;
			while (num != 0) {

				for (int i = 1; i <= 5; i++) {
					num = q.poll();
					num -= i;

					if (num < 0) {
						num = 0;
					}
					q.add(num);
					if (num == 0)
						break;
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
