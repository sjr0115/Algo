package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d4_7208_지도칠하기 {
   static int N, ans;
   static int[][] map;
   static boolean[][] visited;
   static int[] colors;
   public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int T = Integer.parseInt(br.readLine());
         for(int t = 1; t <= T; t++) {
        	 N = Integer.parseInt(br.readLine());
        	 colors = new int[N];
        	 map = new int[N][N];
        	 visited = new boolean[N][N];
        	 StringTokenizer st = new StringTokenizer(br.readLine());
        	 for(int i = 0; i < N; i++) {
        		 colors[i] = Integer.parseInt(st.nextToken());
        	 }
        	 for(int i = 0; i < N; i++) {
        		 st = new StringTokenizer(br.readLine());
        		 for(int j = 0; j < N; j++) {
        			 map[i][j] = Integer.parseInt(st.nextToken());
        		 }
        	 }
        	 ans = 0;
        	 dfs(0);
        	 System.out.println("#" + t + " " + ans);
         }
         
   }
   public static void dfs(int idx) {
	   if(idx == N) {
		   return;
	   }
	   for(int i = idx; i < N; i++) {
		   if(map[idx][i] != 0 && !visited[idx][i]) {
			   visited[idx][i] = true;
			   if(colors[idx] == colors[i]) {
				   ans++;
				   colors[i]++;
			   }
			   dfs(i);
		   }
	   }
   }
}
