package 백준;

import java.io.*;
import java.util.*;

public class 음악프로그램 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int[] pre = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K - 1; j++) {
				int end = Integer.parseInt(st.nextToken());
				list[start].add(end);
				start = end;
				pre[end]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if(pre[i] == 0) {
				q.add(i);
			}
		}
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int cur = q.poll();
			cnt++;
			sb.append(cur).append("\n");
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				pre[next]--;
				if(pre[next] == 0) {
					q.add(next);
				}
			}
		}
		if(cnt != N) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}

}
