package 알골강의;

import java.io.*;
import java.util.*;

public class 막대문제_dp_트리플나치 {
	static int[] memo;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	memo = new int[N + 1];
    	memo[1] = 1;
    	memo[2] = 2;
    	memo[3] = 4;
    	memo[4] = 7;
//    	for (int i = 4; i <= N; i++) {
//			memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
//		}
    	
    	for (int i = 5; i <= N; i++) {
			memo[i] = 2 * memo[i - 1] - memo[i - 4];
		}
    	System.out.println(memo[N]);
    }

}