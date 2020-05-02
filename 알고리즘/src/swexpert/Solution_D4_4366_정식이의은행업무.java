package swexpert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution_D4_4366_정식이의은행업무 {
	static StringBuilder two, three;
	static List<String> binaryList;
	static List<String> tripleList;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			two = new StringBuilder();
			three = new StringBuilder();
			two = two.append(br.readLine());
			three = three.append(br.readLine());
			binaryList = new ArrayList<String>();
			tripleList = new ArrayList<String>();
			ans = 0;
			
			search();
			System.out.println("#" + t + " " + calc());
		}
	}

	private static void search() {
		for (int i = 0; i < two.length(); i++) {
			if(two.charAt(i) == '0') {
				two.setCharAt(i, '1');
				binaryList.add(two.toString());
				two.setCharAt(i, '0');
			} else {
				two.setCharAt(i, '0');
				binaryList.add(two.toString());
				two.setCharAt(i, '1');
			}
		}
		
		for (int i = 0; i < three.length(); i++) {
			if(three.charAt(i) == '0') {
				three.setCharAt(i, '1');
				tripleList.add(three.toString());
				three.setCharAt(i, '2');
				tripleList.add(three.toString());
				three.setCharAt(i, '0');
			} else if(three.charAt(i) == '1'){
				three.setCharAt(i, '0');
				tripleList.add(three.toString());
				three.setCharAt(i, '2');
				tripleList.add(three.toString());
				three.setCharAt(i, '1');
			} else {
				three.setCharAt(i, '0');
				tripleList.add(three.toString());
				three.setCharAt(i, '1');
				tripleList.add(three.toString());
				three.setCharAt(i, '2');
			}
		}
		
	}

	private static int calc() {
		int[] twoCalc = new int[binaryList.size()];
		int[] threeCalc = new int[tripleList.size()];
		
		int size = 0;
		for (int i = 0; i < binaryList.size(); i++) {
			size = binaryList.get(i).length();
			for (int j = 0; j < binaryList.get(i).length(); j++) {
				size--;
				twoCalc[i] += (binaryList.get(i).charAt(j) - '0') * Math.pow(2, size);
			}
		}
		
		loop : for (int i = 0; i < tripleList.size(); i++) {
			size = tripleList.get(i).length();
			for (int j = 0; j < tripleList.get(i).length(); j++) {
				size--;
				threeCalc[i] += (tripleList.get(i).charAt(j) - '0') * Math.pow(3, size);
			}
			for (int j = 0; j < twoCalc.length; j++) {
				if(threeCalc[i] == twoCalc[j]) {
					ans = threeCalc[i];
					break loop;
				}
			}
		}
		return ans;
	}

}
