package swexpert;

import java.io.*;
import java.util.*;

public class Solution_D4_6109_추억의2048게임 {
	static int[][] map;
	static int N;
	static String dir;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sum();
			
			sb.append("#" + t + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void sum() {
		if(dir.equals("left")) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if(map[i][j] != 0) {
						for (int k = j + 1; k < N; k++) {
							if(map[i][k] != 0) {
								if(map[i][j] == map[i][k]) {
									map[i][j] *= 2;
									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
			}
		} else if(dir.equals("right")) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > 0; j--) {
					if(map[i][j] != 0) {
						for (int k = j - 1; k >= 0; k--) {
							if(map[i][k] != 0) {
								if(map[i][j] == map[i][k]) {
									map[i][j] *= 2;
									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
			}
		} else if(dir.equals("up")) {
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N - 1; i++) {
					if(map[i][j] != 0) {
						for (int k = i + 1; k < N; k++) {
							if(map[k][j] != 0) {
								if(map[i][j] == map[k][j]) {
									map[i][j] *= 2;
									map[k][j] = 0;
								}
								break;
							}
						}
					}
				}
			}
		} else if(dir.equals("down")) {
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i > 0; i--) {
					if(map[i][j] != 0) {
						for (int k = i - 1; k >= 0; k--) {
							if(map[k][j] != 0) {
								if(map[i][j] == map[k][j]) {
									map[i][j] *= 2;
									map[k][j] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
		move();
	}

	private static void move() {
		int idx;
		if(dir.equals("left")) {
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if(map[i][j] != 0) {
						idx = -1;
						for (int k = j - 1; k >= 0; k--) {
							if(map[i][k] != 0) {
								break;
							}
							idx = k;
						}
						if(idx != -1) {
							map[i][idx] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		} else if(dir.equals("right")) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 2; j >= 0; j--) {
					if(map[i][j] != 0) {
						idx = -1;
						for (int k = j + 1; k < N; k++) {
							if(map[i][k] != 0) {
								break;
							}
							idx = k;
						}
						if(idx != -1) {
							map[i][idx] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		} else if(dir.equals("up")) {
			for (int j = 0; j < N; j++) {
				for (int i = 1; i < N; i++) {
					if(map[i][j] != 0) {
						idx = -1;
						for (int k = i - 1; k >= 0; k--) {
							if(map[k][j] != 0) {
								break;
							}
							idx = k;
						}
						if(idx != -1) {
							map[idx][j] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		} else if(dir.equals("down")) {
			for (int j = 0; j < N; j++) {
				for (int i = N - 2; i >= 0; i--) {
					if(map[i][j] != 0) {
						idx = -1;
						for (int k = i + 1; k < N; k++) {
							if(map[k][j] != 0) {
								break;
							}
							idx = k;
						}
						if(idx != -1) {
							map[idx][j] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		}
	}

}
