package 알골강의;

import java.util.Scanner;

public class RemoteCon {

	static int s, e;
	static int min = 40;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		e = sc.nextInt();
		remote(s, 0);
		System.out.println(min);
	}
	private static void remote(int temp, int cnt) {
		if(cnt > min) {
			return;
		}
		if(temp == e) {
			if(cnt < min) {
				min = cnt;
			}
			return;
		}
		if(temp < e) {
			remote(temp + 10, cnt + 1);
			remote(temp + 5, cnt + 1);
			remote(temp + 1, cnt + 1);
		} else {
			remote(temp - 10, cnt + 1);
			remote(temp - 5, cnt + 1);
			remote(temp - 1, cnt + 1);
		}
	}

}
