package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class 최적경로_강사코딩 {

	static int N; // 고객집의 수
	static int min, CX, CY, HX, HY; // min : 최소이동거리, CX, CY : 회사좌표, HX, HY : 집좌
	static int[][] customers; // 고객N명 집의 좌표

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			customers = new int[N][2]; // [i][0] : x좌표, [i][1] : y좌표
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			CX = Integer.parseInt(st.nextToken());
			CY = Integer.parseInt(st.nextToken());
			HX = Integer.parseInt(st.nextToken());
			HY = Integer.parseInt(st.nextToken());

			// 고객집 좌표
			for (int i = 0; i < N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());

			}
			go(0, 0, CX, CY, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void go(int count, int visited, int bx, int by, int result) {
		if(result >= min) return; //가지치기 : 기존까지 순열로 처리 중인 고객집들까지 이동했던 거리가 기존min 값보다 크다면
								  // 		더 이상 고객집을 방문해도 이동거리는 커질 수 밖에 없으므로 가지치
		if (count == N) { //기저조건
			result += Math.abs(bx - HX) + Math.abs(by - HY);
			if(min > result) {
				min = result;
			}
			return;
		}
		for (int i = 0; i < N; i++) { // 모든 고객 집을 다 count 위치에 시
			if ((visited & 1 << i) == 0) { // visited & 1 << i : i 고객집이 기존 순열에 처리되었는지 확인 :
											// 0 -> 처리 안됨, 0 아님 -> 처리되었음
				// visited | (i << i) : 기존 순열상태 i고객집 추가
				go(count + 1, visited | (1 << i), customers[i][0], customers[i][1], 
				   result + Math.abs(bx - customers[i][0]) + Math.abs(by - customers[i][1]));

			}
		}
	}
}
