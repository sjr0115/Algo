package 백준;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 세탁소사장동혁_X {
	static int C, penny, nickel, dime, quarter, cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			C = Integer.parseInt(br.readLine());
			penny = 0;
			nickel = 0;
			dime = 0;
			quarter = 0;
			cnt = Integer.MAX_VALUE;
			
			Queue<dala> q = new LinkedList<dala>();
			q.add(new dala(0, 0, 0, 0, 0, 0));
			
			while(!q.isEmpty()) {
				dala cur = q.poll();
				
				if(cur.sum == C) {
					if(cur.cnt < cnt) {
						penny = cur.penny;
						nickel = cur.nickel;
						dime = cur.dime;
						quarter = cur.quarter;
						cnt = cur.cnt;
					}
					continue;
				}
				
				if(cur.cnt < cnt) {
					if(cur.sum + 1 <= C) {
						q.add(new dala(cur.penny + 1, cur.nickel, cur.dime, cur.quarter, cur.cnt + 1, cur.sum + 1));
					}
					if(cur.sum + 5 <= C) {
						q.add(new dala(cur.penny, cur.nickel + 1, cur.dime, cur.quarter, cur.cnt + 1, cur.sum + 5));
					}
					if(cur.sum + 10 <= C) {
						q.add(new dala(cur.penny, cur.nickel, cur.dime + 1, cur.quarter, cur.cnt + 1, cur.sum + 10));
					}
					if(cur.sum + 25 <= C) {
						q.add(new dala(cur.penny, cur.nickel, cur.dime, cur.quarter + 1, cur.cnt + 1, cur.sum + 25));
					}
				}
			}
			
			sb.append(quarter + " " + dime + " " + nickel + " " + penny + "\n");
		}
		System.out.println(sb.toString());
	}

	static class dala {
		int penny, nickel, dime, quarter, cnt, sum;

		public dala(int penny, int nickel, int dime, int quarter, int cnt, int sum) {
			super();
			this.penny = penny;
			this.nickel = nickel;
			this.dime = dime;
			this.quarter = quarter;
			this.cnt = cnt;
			this.sum = sum;
		}
	}
}
