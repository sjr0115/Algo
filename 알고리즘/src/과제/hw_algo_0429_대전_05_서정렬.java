package 과제;

import java.io.*;
import java.util.*;

public class hw_algo_0429_대전_05_서정렬 {
	static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<Integer>();
			int sum = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
				sum += list.get(i);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			int sail = N / 3;
			for (int i = 1; i <= sail; i++) {
				sum -= list.get(3 * i - 1);
			}
			sb.append("#" + t + " " + sum + "\n");
		}
		System.out.println(sb);
	}

}