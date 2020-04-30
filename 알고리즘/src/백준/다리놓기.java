package 백준;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 다리놓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == M) {
				System.out.println(1);
				continue;
			}
			
			BigInteger num = new BigInteger("1");
			
			for (int i = M; i > M - N; i--) {
				num = num.multiply(BigInteger.valueOf(i));
			}
			
			for (int i = N; i > 0; i--) {
				num = num.divide(BigInteger.valueOf(i));
			}
			
			System.out.println(num);
		}
	}

}
