package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_d4_4111_무선단속카메라 {
	static int N, K;
	static TreeSet<Integer> ts;
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= T; t++){
			N = Integer.parseInt(bf.readLine());
			K = Integer.parseInt(bf.readLine());
			ts = new TreeSet<>();
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int i = 0; i < N; i++) {
				ts.add(Integer.parseInt(st.nextToken()));
			}
			int size = ts.size();
			Iterator<Integer> it = ts.iterator();
			
			int[] camera = new int[size];
			for(int i = 0; i < size; i++) {
				camera[i] = it.next();
			}
			int ans = camera[size - 1] - camera[0];
			int[] len = new int[size - 1];
			for(int i = 1; i < size; i++) {
				len[i - 1] = camera[i] - camera[i - 1];
				len[i - 1] = -len[i - 1];
			}
			Arrays.sort(len);
			
			if(K >= size) {
				ans = 0;
			}else {
				for(int i = 1; i < K; i++) {
					ans += len[i - 1];
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
