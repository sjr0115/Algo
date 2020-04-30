package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_d4_8382_방향전환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x = Math.abs(x1 - x2);
			int y = Math.abs(y1 - y2);
			int max = Math.max(x, y);
			int min = Math.min(x, y);
			
			int ans = min * 2;
			max -= min;
			ans += max * 2 - (max % 2);
			System.out.println("#" + t + " " + ans);
		}
	}
}
