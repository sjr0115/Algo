package swexpert;

import java.io.*;
import java.util.*;

public class Solution_모의_5658_보물상자비밀번호 {
	static int N, K, start, end;
	static String alpha;
	static List<Integer> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			alpha = br.readLine();
			list = new ArrayList<Integer>();
			String a = alpha + alpha.substring(0, N / 4 - 1);
			for (int i = 0; i < N; i++) {
				String s = a.substring(i, i + N / 4);
				int num = Integer.parseInt(s, 16);
				if(!list.contains(num)) {
					list.add(num);
				}
			}
			Collections.sort(list, Collections.reverseOrder());
			sb.append("#" + t + " " + list.get(K - 1) + "\n");
		}
		System.out.println(sb);
	}

}
