package swexpert;

import java.io.*;

public class Solution_d3_1213_String {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String data1 = br.readLine();
			char[] search = new char[data1.length()];
			search = data1.toCharArray();
			String data2 = br.readLine();
			char[] en = new char[data2.length()];
			en = data2.toCharArray();
			int cnt = 0;
			while(true) {
				int j = 0;
				for(int i = 0; i < en.length; i++) {
					if(en[i] == search[j]) {
						j++;
						if(j == search.length) {
							cnt++;
							j = 0;
						}
					}else {
						j = 0;
						if(en[i] == search[j]) {
							j++;
						}
					}
				}
				break;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
