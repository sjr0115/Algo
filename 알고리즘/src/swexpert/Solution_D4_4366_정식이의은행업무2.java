package swexpert;

import java.io.*;
 
public class Solution_D4_4366_정식이의은행업무2 {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) {
			String two = br.readLine();
			String three = br.readLine();
			int ans = 0;
			
			int[] twoArr = new int[two.length()];
			for (int i = 0; i < twoArr.length; i++) {
				twoArr[i] = Integer.parseInt(two.charAt(i) + "");
			}
			
			loop : for (int i = 0; i < twoArr.length; i++) {
				twoArr[i] = (twoArr[i] + 1) % 2;
				
				int sum = 0;
				for (int j = 0, k = twoArr.length - 1; j < twoArr.length; j++, k--) {
					sum += Math.pow(2, k) * twoArr[j];
				}
				
				twoArr[i] = Integer.parseInt(two.charAt(i) + "");
				int num = sum;
				String comp = "";
				while(sum > 0) {
					comp += sum % 3;
					sum /= 3;
				}
				
				int wrong = 0;
				for (int j = comp.length() - 1, k = 0; j >= 0; j--, k++) {
					if(comp.charAt(j) != three.charAt(k)) {
						wrong++;
					}
					if(wrong > 1) break;
				}
				
				if(wrong == 1) {
					ans = num;
					break loop;
				}
			}
			
			sb.append("#" + t + " " + ans + "\n");
		}
    	System.out.println(sb.toString());
    }
  
}