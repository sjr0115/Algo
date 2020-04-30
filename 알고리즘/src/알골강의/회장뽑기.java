package 알골강의;

import java.io.*;
import java.util.*;

public class 회장뽑기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] member = new int[N + 1][N + 1];
		int INF = 10000000;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(member[i], INF);
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == -1 && b == - 1) break;
			member[a][b] = member[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(i == k) continue;
				for (int j = 1; j <= N; j++) {
					if(member[k][j] != INF && member[i][k] != INF
					  && member[i][j] > member[i][k] + member[k][j]) {
						member[i][j] = member[i][k] + member[k][j];
					}
				}
			}
		}
		
		int[] memberCnt = new int[N + 1];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j) continue;
				memberCnt[i] = Math.max(memberCnt[i], member[i][j]);
			}
			min = Math.min(min, memberCnt[i]);
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(min == memberCnt[i]) {
				arr.add(i);
			}
		}
		sb.append(min + " " + arr.size() + "\n");
		
		for (Integer i : arr) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString());
	}

}
