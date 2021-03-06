package swexpert;

import java.io.*;
import java.util.*;
 
public class test {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String wrong2 = br.readLine();
			String wrong3 = br.readLine();
			
			char[] char2 = wrong2.toCharArray();
			char[] char3 = wrong3.toCharArray();
			
			List<Long> candidates = new ArrayList<>();
			for (int i = 0; i < char2.length; i++) {
				char2[i] = char2[i] == '0' ? '1' : '0';
				candidates.add(toDigit(char2, 2));
				char2[i] = char2[i] == '0' ? '1' : '0';
			}
			
			Collections.sort(candidates);
			long ans = 0;
			loop : for (int i = 0; i < char3.length; i++) {
				for (char j = '0'; j < '3'; j++) {
					char origin = char3[i];
					if(char3[i] != j) {
						char3[i] = j;
					}
					
					long digit10 = toDigit(char3, 3);
					if(Collections.binarySearch(candidates, digit10) >= 0) {
						ans = digit10;
						break loop;
					}
					char3[i] = origin;
				}
			}
			sb.append("#" + t + " " + ans);
		}
		System.out.println(sb.toString());
	}

	private static Long toDigit(char[] chars, int digits) {
		long num = 0;
		for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
			num += (chars[i] - '0') * Math.pow(digits, j); 
		}
		return num;
	}
}