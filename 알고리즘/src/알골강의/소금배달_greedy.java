package 알골강의;

import java.io.*;

public class 소금배달_greedy {
/*
3kg 5kg
greedy
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
//		int cnt = M / 5 + M % 5 / 3; 가설이 틀림
		int cnt = 0;
//		21kg 5 5 5 3 3
//		18   3
//		15	 3 3 5 5 5
//		4kg  x
//		1    3
//		-2   3 3
//		-5   3 3 3
		while(M % 5 != 0) { //5로 나누어 떨어지지 않는다면
			M -= 3;
			cnt++;
		}
		
		if(M < 0) { //음수
			System.out.println(-1);
		} else {
			cnt += M / 5;
			System.out.println(cnt);
		}
//		Greedy
//		3kg 5kg 7kg 11kg
//		소금 봉지의 무게 종류
	}

}
