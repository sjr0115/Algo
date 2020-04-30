package swexpert;

import java.io.*;

public class Solution_d3_9317_석찬이의받아쓰기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String data1 = br.readLine();
			String data2 = br.readLine();
			char[] en = new char[N];
			char[] seok = new char[N];
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				en[i] = data1.charAt(i);
				seok[i] = data2.charAt(i);
				if(en[i] == seok[i]) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
