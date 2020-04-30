package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 키순서 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] students = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			students[a][b] = true;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(k == i) continue;
				for (int j = 1; j <= N; j++) {
					if(students[i][k] && students[k][j]) {
						students[i][j] = true;
					}
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				if(students[i][j] || students[j][i]) {
					cnt++;
				}
			}
			if(cnt == N - 1) ans++;
		}
		
		System.out.println(ans);
	}
}
