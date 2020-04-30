package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d4_7701_염라대왕의이름정렬 {
	static int N;
	static String[] names;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			TreeSet<String> names = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o1.length() - o2.length();
				}
			});
			
			for (int i = 0; i < N; i++) {
				names.add(br.readLine());
			}
			
			System.out.println("#" + t + " ");
			for (String i : names) {
				System.out.println(i);
			}
		}

	}
}
