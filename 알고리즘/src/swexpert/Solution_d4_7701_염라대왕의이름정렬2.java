package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d4_7701_염라대왕의이름정렬2 {
	static int N;
	static String[] names;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			TreeSet<String>[] tsrr = new TreeSet[51];
			for (int i = 0; i < tsrr.length; i++) {
				tsrr[i] = new TreeSet<String>();
			}
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				tsrr[str.length()].add(str);
			}
			
			bw.write("#" + t + " \n");
			for (int i = 1; i < tsrr.length; i++) {
				for (String s : tsrr[i]) {
					bw.write(s + "\n");
				}
			}
		}
		bw.flush();
		bw.close();

	}
}