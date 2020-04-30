package swexpert;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_3378_스타일리쉬들여쓰기 {
	static int p, q;
	static String[] ps, qs;
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			ps = new String[p];
			qs = new String[q];
			
			for (int i = 0; i < p; i++) {
				ps[i] = br.readLine();
			}
			
			for (int i = 0; i < q; i++) {
				qs[i] = br.readLine();
			}
			
			result = new int[q];
			Arrays.fill(result, -2);
			for (int i = 1; i <= 20; i++) {
				for (int j = 1; j <= 20; j++) {
					for (int k = 1; k <= 20; k++) {
						if(rcsCnt(i, j, k)) {
							qCheck(i, j, k);
						}
					}
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}

	private static void qCheck(int r, int c, int s) {
		int R, C, S;
		R = C = S = 0;
		for (int i = 0; i < qs.length; i++) {
			int RCS = R * r + C * c + S * s;
			String st = qs[i];
			
			
			if(result[i] == -2) {
				result[i] = RCS;
			} else if(result[i] != RCS) {
				result[i] = -1;
			}
			
			for (int j = 0; j < st.length(); j++) {
				if(st.charAt(j) == '(') R++;
				else if(st.charAt(j) == ')') R--;
				else if(st.charAt(j) == '{') C++;
				else if(st.charAt(j) == '}') C--;
				else if(st.charAt(j) == '[') S++;
				else if(st.charAt(j) == ']') S--;
			}
		}
	}

	private static boolean rcsCnt(int r, int c, int s) {
		int R, C, S;
		R = C = S = 0;
		
		for (int i = 0; i < ps.length; i++) {
			int dot = 0;
			String st = ps[i];
			for (int j = 0; j < st.length(); j++) {
				if(st.charAt(j) == '.') dot++;
				else break;
			}
			
			if(R * r + C * c + S * s != dot) return false;
			
			for (int j = 0; j < st.length(); j++) {
				if(st.charAt(j) == '(') R++;
				else if(st.charAt(j) == ')') R--;
				else if(st.charAt(j) == '{') C++;
				else if(st.charAt(j) == '}') C--;
				else if(st.charAt(j) == '[') S++;
				else if(st.charAt(j) == ']') S--;
			}
		}
		return true;
	}

}
