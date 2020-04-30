package swexpert;

import java.io.*;

public class Solution_d3_1216_회문2 {
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[100][100];
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < 100; i++) {
				String data = br.readLine();
				map[i] = data.toCharArray();
			}
			int ans = 0;
			for(int num = 100; num > 1; num--) {
				if(ans > 1) break;
				
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100 - num + 1; j++) {
						int temp = 0;
						for (int k = 0; k < num / 2; k++) {
							if(map[i][j + k] != map[i][j + num - k - 1]) {
								temp = -1;
							}
						}
						if(temp == 0) {
							ans = num;
						}
					}
				}
				
				for(int i = 0; i < 100 - num + 1; i++) {
					for(int j = 0; j < 100; j++) {
						int temp = 0;
						for(int k = 0; k < num / 2; k++) {
							if(map[i + k][j] != map[i + num - k - 1][j]) {
								temp = -1;
							}
						}
						if(temp == 0) {
							ans = num;
						}
					}
				}
				
			}
			System.out.println("#" + t + " " + ans);
		}
	}

}
