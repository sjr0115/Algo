package 알골강의;

import java.util.Arrays;

public class 중복순열 {
	static char[] chars = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {

		int r = 3;
		makePermutation(r, new char[r]);
	}

	public static void makePermutation(int r, char[] temp) {
		if (r == 0) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for (int i = 0; i < chars.length; i++) {
			temp[r - 1] = chars[i];
			makePermutation(r - 1, temp);

		}
	}
}
