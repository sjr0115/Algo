package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 숫자고르기 {
	static int[] arr;
	static boolean[] visited;
	static int checkNum;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			int u = Integer.parseInt(br.readLine());
			arr[i] = u; 
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			checkNum = i;
			dfs(i);
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size() + "\n");
		for (int i : list) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int cur) {
		if(visited[cur]) return;
		
		int next = arr[cur];
		visited[cur] = true;
		dfs(next);
		visited[cur] = false;

		if(next == checkNum) {
			list.add(checkNum);
		}
	}
}
