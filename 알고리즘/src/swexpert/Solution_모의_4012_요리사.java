package swexpert;

import java.io.*;
import java.util.*;

public class Solution_모의_4012_요리사 {
	static int N, ans;
	static int[][] cook;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			cook = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cook[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N];
			ans = Integer.MAX_VALUE;
			solve(0, 0);
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void solve(int cnt, int idx) {
		if(cnt >= N) return;
		if(idx == N / 2) {
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if(visited[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			int sumA = 0;
			int sumB = 0;
			for (int i = 0; i < A.size() - 1; i++) {
				for (int j = i + 1; j < A.size(); j++) {
					sumA += (cook[A.get(i)][A.get(j)] + cook[A.get(j)][A.get(i)]);
					sumB += (cook[B.get(i)][B.get(j)] + cook[B.get(j)][B.get(i)]);
				}
			}
			
			ans = Math.min(ans, Math.abs(sumA - sumB));
			return;
		}
		
		visited[cnt] = true;
		solve(cnt + 1, idx + 1);
		visited[cnt] = false;
		solve(cnt + 1, idx);
	}

}
