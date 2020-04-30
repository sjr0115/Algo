package swexpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_d3_4751_다솔이의다이아몬드장식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String data = br.readLine();
			char[] en = new char[data.length()];
			en = data.toCharArray();
			Queue<Character> q = new LinkedList<Character>();
			for(int i = 0; i < en.length; i++) {
				q.add(en[i]);
			}
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < en.length * 4 + 1; j++) {
					if (i % 4 == 0) {
						if ((j + 2) % 4 == 0) {
							System.out.print("#");
						} else {
							System.out.print(".");
						}
					} else if (i == 1 || i == 3) {
						if (j % 2 == 1) {
							System.out.print("#");
						} else {
							System.out.print(".");
						}
					} else {
						if (j % 2 == 1) {
							System.out.print(".");
						} else if (j % 4 == 0) {
							System.out.print("#");
						} else {
							System.out.print(q.poll());
						}
					}
				}
				System.out.println();
			}
		}
	}

}
