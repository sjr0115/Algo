package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 배열돌리기4 {
	static int N, M, K;
	static int[][] comand, map, copy;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		comand = new int[K][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		p = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			comand[i][0] = Integer.parseInt(st.nextToken()) - 1;
			comand[i][1] = Integer.parseInt(st.nextToken()) - 1;
			comand[i][2] = Integer.parseInt(st.nextToken());
			p[i] = i;
		}
		
		int min = Integer.MAX_VALUE;
		do {
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, M);
			}
			
			for (int i = 0; i < K; i++) {
				int k = p[i];
				rotate(comand[k][0], comand[k][1], comand[k][2]);
			}
			
			int temp = getMin();
			min = Math.min(min, temp);
		} while(pt(p));
		System.out.println(min);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += copy[i][j];
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	private static void rotate(int r, int c, int s) {
		for (int k = s; k > 0; --k) {
			int start = copy[r - k][c - k];
			
			for (int i = r - k; i < r + k; i++) { // 상
				copy[i][c - k] = copy[i + 1][c - k];
			}
			
			for (int i = c - k; i < c + k; i++) { // 좌
				copy[r + k][i] = copy[r + k][i + 1];
			}
						
			for (int i = r + k; i > r - k; i--) { // 하 
				copy[i][c + k] = copy[i - 1][c + k];
			}
			
			for (int i = c + k; i > c - k; i--) { // 우
				copy[r - k][i] = copy[r - k][i - 1];
			}
			
			copy[r - k][c - k + 1] = start;
		}
	}

	private static boolean pt(int[] p) {
		int i = p.length - 1;
		while(i > 0 && p[i - 1] >= p[i]) --i;
		if(i == 0) return false;
		
		int j = p.length - 1;
		while(p[i - 1] >= p[j]) --j;
		
		int temp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = temp;
		
		int k = p.length - 1;
		while(k > i) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			--k;
			++i;
		}
		return true;
	}

}
