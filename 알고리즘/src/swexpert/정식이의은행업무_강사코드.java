package swexpert;
import java.io.*;
import java.util.*;

public class 정식이의은행업무_강사코드 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {

			long answer = 0;
			String wrong2 = br.readLine();
			String wrong3 = br.readLine();

			char[] char2 = wrong2.toCharArray();
			char[] char3 = wrong3.toCharArray();

			// 2진수의 각 자리수를 하나씩 바꿔가며 10진수로 변경해서 관리
			List<Long> candidates = new ArrayList<>();
			for (int i = 0; i < wrong2.length(); i++) {
				// 변경할 자리수를 저장해뒀다가 원복때 사용
				char2[i] = char2[i] == '0' ? '1' : '0';
				// 이진수를 10진수로 바꿔주자..
				candidates.add(toDigit10(char2, 2));
				// 원복
				char2[i] = char2[i] == '0' ? '1' : '0';
			}
			// System.out.println(candidates);

			Collections.sort(candidates);

			outer: for (int j = 0; j < char3.length; j++) {
				// 변경할 자리수를 저장해뒀다가 원복때 사용
				for (char k = '0'; k < '3'; k++) {
					char old = char3[j];
					if (char3[j] != k) {
						char3[j] = k;
					}
					long digit10 = toDigit10(char3, 3);
					// if (candidates.contains(digit10)) {
					if (Collections.binarySearch(candidates, digit10) >= 0) {
						answer = digit10;
						break outer;
					}
					// 변수 원복
					char3[j] = old;
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static long toDigit10(char[] chars, int digits) {

		long num = 0;
		for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
			num += (chars[i] - '0') * Math.pow(digits, j);
		}
		return num;

		// long result= Long.parseLong(String.valueOf(chars), digits);
		// return result;
	}

	static String src = "1\r\n" + "1010\r\n" + "212";
}
