package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d4_2115_벌꿀채취 {
	static int N, M, C;
	static int[][] map, maxMap; // maxMap : i, j 위치에서 가질 수 있는 최대이
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//1.각 i, j 위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대이익 계산
			makeMaxMap();
			//2. 두 일꾼의 조합
			System.out.println("#" + t + " " + getMaxBenefit());
		}
		
	}
	public static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}
	
	public static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		if(sum > C) return;
		if(cnt == M) {
			if(maxMap[i][j - M] < powSum) {
				maxMap[i][j - M] = powSum;
			}
			return;
		}
		
		//i, j 위치 원소 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]);
		//i, j 위치 원소 비선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum);
	}
	
	public static int getMaxBenefit() {
		int max = 0, temp = 0; // max : 조합적 선택후의 최대이익
		//1. 일꾼A 기준선택
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) { //A일꾼
				//2. 일꾼B 선
				//같은 행기준 선택
				for (int k = j + M; k <= N - M; k++) {
					temp = maxMap[i][j] + maxMap[i][k]; //두 일꾼 조합의 최대이익
					if(max < temp) {
						max = temp;
					}
				}
				//다음행부터 마지막행 까지 선택
				for (int i2 = i + 1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N - M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if(max < temp) {
							max = temp;
						}
					}
				}
			}
		}
		return max;
	}
}
