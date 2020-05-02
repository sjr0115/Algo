package 알골강의;

import java.io.*;
import java.util.*;

public class Solution_d4_4366_정식이의은행업무 {
    public static void main(String[] args) throws Exception {
    	Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        for(int tc=1; tc<=T; tc++){
        	String sbi=sc.next(); //3≤2진수,3진수의 자릿수 <40
        	String ster=sc.next();//int 범위 넘어감->long
        	//2진법 글자수 만큼
        	exit:for(int i=0; i<sbi.length(); i++){
				char digit2;
        		if(sbi.charAt(i)=='1') digit2='0';
				else                   digit2='1';
        		//2진법->10진수로
        		char[] cbi=sbi.toCharArray();
        		cbi[i]=digit2;
        		long binary=Long.valueOf(String.valueOf(cbi),2);
        		//3진법 글자수 만큼
        		for(int j=0; j<ster.length(); j++){
					for(char digit3='0'; digit3<='2'; digit3++){
						if(ster.charAt(j)==digit3) continue;//같으면 skip
						//3진법->10진수로
						char[] cter=ster.toCharArray();
						cter[j]=digit3;
						long ternary=Long.valueOf(String.valueOf(cter),3);
						//값 확인
						if(binary==ternary){
							System.out.println("#"+tc+" "+binary);
							break exit;
						}
					}
				}
			}
        }
        sc.close();
    }
}