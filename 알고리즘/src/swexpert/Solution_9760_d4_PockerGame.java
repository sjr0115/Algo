package swexpert;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_9760_d4_PockerGame {
	static String[] cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cards = new String[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] suit = { 'S', 'D', 'H', 'C' };
			int[] suitCnt = new int[4];
			int[] cardNum = new int[14];
			String ans = "High card";
			int cnt = 0;
			int max = Integer.MIN_VALUE;
			boolean strightCheck = false;
			for (int i = 0; i < 5; i++) {
				cards[i] = st.nextToken();
				if (cards[i].charAt(1) == 'A') {
					cardNum[1]++;
				} else if (cards[i].charAt(1) == 'T') {
					cardNum[10]++;
				} else if (cards[i].charAt(1) == 'J') {
					cardNum[11]++;
				} else if (cards[i].charAt(1) == 'Q') {
					cardNum[12]++;
				} else if (cards[i].charAt(1) == 'K') {
					cardNum[13]++;
				} else {
					cardNum[cards[i].charAt(1) - '0']++;
				}
				for (int j = 0; j < 4; j++) {
					if (cards[i].charAt(0) == suit[j]) {
						suitCnt[j]++;
						if (suitCnt[j] == 5) {
							strightCheck = true;
						}
					}
				}
			}
			int count = 1;
			for (int i = 1; i < 14; i++) {
				max = Math.max(max, cardNum[i]);
			}

			for (int i = 1; i < 13; i++) {
				if (cardNum[i] == cardNum[i + 1] && cardNum[i] != 0) {
					count++;
				}

			}
			if (cardNum[1] == cardNum[13] && cardNum[1] == 1) {
				count++;
			}

			if (max == 2) {
				for (int i = 1; i < cardNum.length; i++) {
					if (cardNum[i] == 2) {
						cnt++;
					}
				}
				if (cnt == 2) {
					ans = "Two pair";
				} else if (cnt == 1) {
					ans = "One pair";
				}
			} else if (max == 3) {
				for (int i = 1; i < cardNum.length; i++) {
					if(cardNum[i] == 2) {
						cnt++;
					} 
				}
				if(cnt == 1) {
					ans = "Full House";
				} else if(cnt == 0) {
					ans = "Three of a kind";
				}
			} else if (max == 4) {
				ans = "Four of a Kind";
			} else if (max == 1) {
				if (strightCheck && count == 5) {
					ans = "Straight Flush";
				} else if (count == 5) {
					ans = "Straight";
				} else if(strightCheck) {
					ans = "Flush";
				}
			}
			System.out.println("#" + t + " " + ans);
		}

	}

}
